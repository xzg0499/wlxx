package com.xzg.wlxx.apt;

import cn.hutool.core.util.StrUtil;
import com.sun.source.util.Trees;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

/**
 * @author XiaoZG
 */
public abstract class BaseProcessor extends AbstractProcessor {

    protected Messager messager;

    protected Filer filer;

    protected Elements elements;

    protected Trees trees;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        messager = processingEnv.getMessager();
        filer = processingEnv.getFiler();
        elements = processingEnv.getElementUtils();

        trees = Trees.instance(processingEnv);
    }

    public void note(String msg, Object... param) {
        messager.printMessage(Diagnostic.Kind.NOTE, StrUtil.format(msg, param));
    }
}