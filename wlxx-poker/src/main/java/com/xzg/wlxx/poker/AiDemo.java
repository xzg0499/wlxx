package com.xzg.wlxx.poker;

import ai.djl.Model;
import ai.djl.basicdataset.cv.classification.Mnist;
import ai.djl.basicmodelzoo.basic.Mlp;
import ai.djl.ndarray.types.Shape;
import ai.djl.nn.Blocks;
import ai.djl.nn.SequentialBlock;
import ai.djl.nn.core.Linear;
import ai.djl.training.DefaultTrainingConfig;
import ai.djl.training.EasyTrain;
import ai.djl.training.Trainer;
import ai.djl.training.dataset.Dataset;
import ai.djl.training.evaluator.Accuracy;
import ai.djl.training.listener.TrainingListener;
import ai.djl.training.loss.Loss;
import ai.djl.training.util.ProgressBar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author xzgan
 * @date 2022/6/10
 * @since jdk1.8
 */
public class AiDemo {
    public static void main(String[] args) throws Exception {
        test1();
    }

    public static void test1() throws Exception {
        int batchSize = 32;
        Mnist mnist = Mnist.builder().setSampling(batchSize, true).build();
        mnist.prepare(new ProgressBar());
        Model model = Model.newInstance("mlp");

        model.setBlock(new Mlp(28 * 28, 10, new int[] {128, 64}));
        DefaultTrainingConfig config = new DefaultTrainingConfig(Loss.softmaxCrossEntropyLoss()).addEvaluator(new Accuracy()).addTrainingListeners(TrainingListener.Defaults.logging());
        Trainer trainer = model.newTrainer(config);
        trainer.initialize(new Shape(1, 28 * 28));
        int epoch = 2;
        EasyTrain.fit(trainer, epoch, mnist, null);
        Path modelDir = Paths.get("build/mlp");
        Files.createDirectories(modelDir);
        model.setProperty("Epoch", String.valueOf(epoch));
        model.save(modelDir, "mlp");
        System.out.println(model);
    }

    public static void test() {
        int batchSize = 32;
        Mnist trainingDataset = Mnist.builder()
                .optUsage(Dataset.Usage.TRAIN)
                .setSampling(batchSize, true)
                .build();
        Mnist validatationDataset = Mnist.builder()
                .optUsage(Dataset.Usage.TEST)
                .setSampling(batchSize, true)
                .build();

        int input = 28 * 28;
        int output = 10;
        int[] hidden = new int[]{128, 64};
        SequentialBlock sequentialBlock = new SequentialBlock();
        sequentialBlock.add(Blocks.batchFlattenBlock(input));
        for (int hiddenSize : hidden) {
            sequentialBlock.add(Linear.builder().setUnits(hiddenSize).build());
//            sequentialBlock.add(activerecord);
        }
        sequentialBlock.add(Linear.builder().setUnits(output).build());

        DefaultTrainingConfig config = new DefaultTrainingConfig(
                Loss.softmaxCrossEntropyLoss()
        ).addEvaluator(new Accuracy())
                .addTrainingListeners(TrainingListener.Defaults.logging());
//        try(Trainer trainer = model.new ai.djl.training.Trainer()){

//        }
    }
}
