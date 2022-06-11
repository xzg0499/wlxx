package com.xzg.wlxx.poker;

import ai.djl.Application;
import ai.djl.MalformedModelException;
import ai.djl.Model;
import ai.djl.basicdataset.cv.classification.Mnist;
import ai.djl.basicdataset.tabular.CsvDataset;
import ai.djl.basicdataset.utils.DynamicBuffer;
import ai.djl.basicmodelzoo.basic.Mlp;
import ai.djl.engine.Engine;
import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.modality.cv.util.NDImageUtils;
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
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NDArrayLearning {
    public static void main(String[] args) throws IOException, TranslateException, MalformedModelException, ModelNotFoundException {
//        Image img = ImageFactory.getInstance().fromUrl("https://resources.djl.ai/images/0.png");
        Image img = ImageFactory.getInstance().fromFile(new File("E:\\Project\\Snipaste_2022-06-10_19-13-58.png").getAbsoluteFile().toPath());
        img.getWrappedImage();
        Path modelDir = Paths.get("build/mlp");


        Model model = Model.newInstance("mlp");
//        import ai.djl.basicmodelzoo.basic.Mlp;
        model.setBlock(new Mlp(28*28, Mnist.NUM_CLASSES, new int[] {128, 64}));
//        model.setBlock(new Mlp);
        model.load(modelDir);

        Translator<Image, Classifications> translator = new Translator<Image, Classifications>() {

            @Override
            public NDList processInput(TranslatorContext ctx, Image input) {
                // Convert Image to NDArray
                NDArray array = input.toNDArray(ctx.getNDManager(), Image.Flag.GRAYSCALE);
                return new NDList(NDImageUtils.toTensor(array));
            }

            @Override
            public Classifications processOutput(TranslatorContext ctx, NDList list) {
                // Create a Classifications with the output probabilities
                NDArray probabilities = list.singletonOrThrow().softmax(0);
                List<String> classNames = IntStream.range(0, 10).mapToObj(String::valueOf).collect(Collectors.toList());
                return new Classifications(classNames, probabilities);
            }

            @Override
            public Batchifier getBatchifier() {
                // The Batchifier describes how to combine a batch together
                // Stacking, the most common batchifier, takes N [X1, X2, ...] arrays to a single [N, X1, X2, ...] array
                return Batchifier.STACK;
            }
        };
        Predictor<Image, Classifications> predictor = model.newPredictor(translator);
        Classifications classifications = predictor.predict(img);
        System.out.println(classifications);

//        String review = "It works great, but it takes too long to update itself and slows the system";
//        Predictor<String, Classifications> predictor = model.newPredictor(new MyTranslator(tokenizer));
//        System.out.println(predictor.predict(review));


    }

    final class BertFeaturizer implements CsvDataset.Featurizer {

        private final BertFullTokenizer tokenizer;
        private final int maxLength; // the cut-off length

        public BertFeaturizer(BertFullTokenizer tokenizer, int maxLength) {
            this.tokenizer = tokenizer;
            this.maxLength = maxLength;
        }

        /** {@inheritDoc} */
        @Override
        public void featurize(DynamicBuffer buf, String input) {
            Vocabulary vocab = tokenizer.getVocabulary();
            // convert sentence to tokens (toLowerCase for uncased model)
            List<String> tokens = tokenizer.tokenize(input.toLowerCase());
            // 超出maxLength的进行截取
            tokens = tokens.size() > maxLength ? tokens.subList(0, maxLength) : tokens;
            // BERT embedding convention "[CLS] Your Sentence [SEP]"
            buf.put(vocab.getIndex("[CLS]"));
            tokens.forEach(token -> buf.put(vocab.getIndex(token)));
            buf.put(vocab.getIndex("[SEP]"));
        }
    }




    class MyTranslator implements Translator<String, Classifications> {

        private BertFullTokenizer tokenizer;
        private Vocabulary vocab;
        private List<String> ranks;

        public MyTranslator(BertFullTokenizer tokenizer) {
            this.tokenizer = tokenizer;
            vocab = tokenizer.getVocabulary();
            ranks = Arrays.asList("1", "2", "3", "4", "5");
        }

        @Override
        public Batchifier getBatchifier() { return new StackBatchifier(); }

        @Override
        public NDList processInput(TranslatorContext ctx, String input) {
            List<String> tokens = tokenizer.tokenize(input);
            float[] indices = new float[tokens.size() + 2];
            indices[0] = vocab.getIndex("[CLS]");
            for (int i = 0; i < tokens.size(); i++) {
                indices[i+1] = vocab.getIndex(tokens.get(i));
            }
            indices[indices.length - 1] = vocab.getIndex("[SEP]");
            return new NDList(ctx.getNDManager().create(indices));
        }

        @Override
        public Classifications processOutput(TranslatorContext ctx, NDList list) {
            return new Classifications(ranks, list.singletonOrThrow().softmax(0));
        }
    }


}

