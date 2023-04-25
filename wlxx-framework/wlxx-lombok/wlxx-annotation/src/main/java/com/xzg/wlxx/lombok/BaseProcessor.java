package com.xzg.wlxx.lombok;

import com.sun.source.util.Trees;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * @author xzgan
 * @date 2023/4/24
 */
public abstract class BaseProcessor extends AbstractProcessor {

    protected ProcessingEnvironment env = null;

    protected Filer filer = null;

    protected Elements elements = null;

    protected Messager messager = null;

    protected Trees trees;

    //protected TreeMaker treeMaker;
    protected Types types;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        env = processingEnv;
        filer = processingEnv.getFiler();
        elements = processingEnv.getElementUtils();
        messager = processingEnv.getMessager();

        trees = Trees.instance(processingEnv);

        super.init(processingEnv);
    }


}
