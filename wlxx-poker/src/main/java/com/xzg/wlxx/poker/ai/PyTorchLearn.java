package com.xzg.wlxx.poker.ai;

import ai.djl.Application;
import ai.djl.Device;
import ai.djl.MalformedModelException;
import ai.djl.Model;
import ai.djl.basicdataset.tabular.CsvDataset;
import ai.djl.engine.Engine;
import ai.djl.inference.Predictor;
import ai.djl.metric.Metrics;
import ai.djl.modality.nlp.DefaultVocabulary;
//import ai.djl.modality.nlp.SimpleVocabulary;
import ai.djl.modality.nlp.Vocabulary;
import ai.djl.modality.nlp.bert.BertFullTokenizer;
import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDList;
import ai.djl.ndarray.types.DataType;
import ai.djl.ndarray.types.Shape;
import ai.djl.nn.Activation;
import ai.djl.nn.Block;
import ai.djl.nn.SequentialBlock;
import ai.djl.nn.core.Linear;
import ai.djl.nn.norm.Dropout;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelNotFoundException;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.DefaultTrainingConfig;
import ai.djl.training.EasyTrain;
import ai.djl.training.Trainer;
import ai.djl.training.TrainingResult;
import ai.djl.training.dataset.RandomAccessDataset;
import ai.djl.training.evaluator.Accuracy;
import ai.djl.training.listener.SaveModelTrainingListener;
import ai.djl.training.listener.TrainingListener;
import ai.djl.training.loss.Loss;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.PaddingStackBatchifier;
import ai.djl.translate.TranslateException;
import com.xzg.wlxx.poker.ai.BertFeaturizer;
import org.apache.commons.csv.CSVFormat;

import java.io.IOException;
import java.nio.file.Paths;

public class PyTorchLearn {
    public static void main(String[] args) throws IOException, TranslateException, MalformedModelException, ModelNotFoundException {
        // 根据深度学习引擎，选择要下载的模型
        // MXNet base model
        String modelUrls = "https://resources.djl.ai/test-models/distilbert.zip";
        if ("PyTorch".equals(Engine.getInstance().getEngineName())) {
            modelUrls = "https://resources.djl.ai/test-models/traced_distilbert_wikipedia_uncased.zip";
        }


        Criteria<NDList, NDList> criteria = Criteria.builder()
                .optApplication(Application.NLP.WORD_EMBEDDING)
                .setTypes(NDList.class, NDList.class)
                .optModelUrls(modelUrls)
                .optProgress(new ProgressBar())
                .build();
        ZooModel<NDList, NDList> embedding = criteria.loadModel();

        Predictor<NDList, NDList> embedder = embedding.newPredictor();
        Block classifier = new SequentialBlock()
                // text embedding layer
                .add(
                        ndList -> {
                            NDArray data = ndList.singletonOrThrow();
                            NDList inputs = new NDList();
                            long batchSize = data.getShape().get(0);
                            float maxLength = data.getShape().get(1);

                            if ("PyTorch".equals(Engine.getInstance().getEngineName())) {
                                inputs.add(data.toType(DataType.INT64, false));
                                inputs.add(data.getManager().full(data.getShape(), 1, DataType.INT64));
                                inputs.add(data.getManager().arange(maxLength)
                                        .toType(DataType.INT64, false)
                                        .broadcast(data.getShape()));
                            } else {
                                inputs.add(data);
                                inputs.add(data.getManager().full(new Shape(batchSize), maxLength));
                            }
                            // run embedding
                            try {
                                return embedder.predict(inputs);
                            } catch (TranslateException e) {
                                throw new IllegalArgumentException("embedding error", e);
                            }
                        })
                // classification layer
                .add(Linear.builder().setUnits(768).build()) // pre classifier
                .add(Activation::relu)
                .add(Dropout.builder().optRate(0.2f).build())
                .add(Linear.builder().setUnits(5).build()) // 5 star rating
                .addSingleton(nd -> nd.get(":,0")); // Take [CLS] as the head
        Model model = Model.newInstance("AmazonReviewRatingClassification");
        model.setBlock(classifier);

        // Prepare the vocabulary
        DefaultVocabulary vocabulary = DefaultVocabulary.builder()
                .optMinFrequency(1)
                .addFromTextFile(embedding.getArtifact("vocab.txt"))
                .optUnknownToken("[UNK]")
                .build();
// Prepare dataset
        int maxTokenLength = 64; // cutoff tokens length
        int batchSize = 8;
        int limit = Integer.MAX_VALUE;
// int limit = 512; // uncomment for quick testing

        BertFullTokenizer tokenizer = new BertFullTokenizer(vocabulary, true);
        CsvDataset amazonReviewDataset = getDataset(batchSize, tokenizer, maxTokenLength, limit);
// split data with 7:3 train:valid ratio
        RandomAccessDataset[] datasets = amazonReviewDataset.randomSplit(7, 3);
        RandomAccessDataset trainingSet = datasets[0];
        RandomAccessDataset validationSet = datasets[1];
        SaveModelTrainingListener listener = new SaveModelTrainingListener("build/model");
        listener.setSaveModelCallback(
                trainer -> {
                    TrainingResult result = trainer.getTrainingResult();
                    Model model1 = trainer.getModel();
                    // track for accuracy and loss
                    float accuracy = result.getValidateEvaluation("Accuracy");
                    model1.setProperty("Accuracy", String.format("%.5f", accuracy));
                    model1.setProperty("Loss", String.format("%.5f", result.getValidateLoss()));
                });
        DefaultTrainingConfig config = new DefaultTrainingConfig(Loss.softmaxCrossEntropyLoss()) // loss type
                .addEvaluator(new Accuracy())
                .optDevices(new Device[]{Device.cpu()}) // train using single GPU
                .addTrainingListeners(TrainingListener.Defaults.logging("build/model"))
                .addTrainingListeners(listener);

        int epoch = 2;

        Trainer trainer = model.newTrainer(config);
        trainer.setMetrics(new Metrics());
        Shape encoderInputShape = new Shape(batchSize, maxTokenLength);
// initialize trainer with proper input shape
        trainer.initialize(encoderInputShape);
        EasyTrain.fit(trainer, epoch, trainingSet, validationSet);
        System.out.println(trainer.getTrainingResult());
        /*
        {
          "epoch": 2,
          "evaluations": {
            "validate_Accuracy": 0.6175798,
            "train_Accuracy": 0.5980856,
            "train_SoftmaxCrossEntropyLoss": 1.0741292,
            "validate_SoftmaxCrossEntropyLoss": 1.0012888,
            "train_loss": 1.0741292,
            "validate_loss": 1.0012888
          }
        }
         */


        model.save(Paths.get("build/model"), "amazon-review.param");
    }

    /**
     * 下载创建数据集对象
     */
    static CsvDataset getDataset(int batchSize, BertFullTokenizer tokenizer, int maxLength, int limit) {
        String amazonReview =
                "https://s3.amazonaws.com/amazon-reviews-pds/tsv/amazon_reviews_us_Digital_Software_v1_00.tsv.gz";
        float paddingToken = tokenizer.getVocabulary().getIndex("[PAD]");
        return CsvDataset.builder()
                .optCsvUrl(amazonReview) // load from Url
                .setCsvFormat(CSVFormat.TDF.withQuote(null).withHeader()) // Setting TSV loading format
                .setSampling(batchSize, true) // make sample size and random access
                .optLimit(limit)
                .addFeature(
                        new CsvDataset.Feature(
                                "review_body", new BertFeaturizer(tokenizer, maxLength)))
                .addLabel(
                        new CsvDataset.Feature(
                                "star_rating", (buf, data) -> buf.put(Float.parseFloat(data) - 1.0f)))
                .optDataBatchifier(
                        PaddingStackBatchifier.builder()
                                .optIncludeValidLengths(false)
                                .addPad(0, 0, (m) -> m.ones(new Shape(1)).mul(paddingToken))
                                .build()) // define how to pad dataset to a fix length
                .build();
    }
}

