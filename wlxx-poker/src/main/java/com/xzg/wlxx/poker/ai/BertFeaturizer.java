package com.xzg.wlxx.poker.ai;

import ai.djl.basicdataset.tabular.CsvDataset;
import ai.djl.basicdataset.utils.DynamicBuffer;
import ai.djl.modality.nlp.DefaultVocabulary;
import ai.djl.modality.nlp.Vocabulary;
import ai.djl.modality.nlp.bert.BertFullTokenizer;

import java.util.List;

/**
 * @author xzgan
 * @date 2022/6/10
 * @since jdk1.8
 */
public class BertFeaturizer implements CsvDataset.Featurizer{
    private final BertFullTokenizer tokenizer;
    private final int maxLength; // the cut-off length

    public BertFeaturizer(BertFullTokenizer tokenizer, int maxLength) {
        this.tokenizer = tokenizer;
        this.maxLength = maxLength;
    }

    /** {@inheritDoc} */
    @Override
    public void featurize(DynamicBuffer buf, String input) {
        DefaultVocabulary vocab = (DefaultVocabulary) tokenizer.getVocabulary();
        // convert sentence to tokens (toLowerCase for uncased model)
        List<String> tokens = tokenizer.tokenize(input.toLowerCase());
        // trim the tokens to maxLength
        tokens = tokens.size() > maxLength ? tokens.subList(0, maxLength) : tokens;
        // BERT embedding convention "[CLS] Your Sentence [SEP]"
        buf.put(vocab.getIndex("[CLS]"));
        tokens.forEach(token -> buf.put(vocab.getIndex(token)));
        buf.put(vocab.getIndex("[SEP]"));
    }

}
