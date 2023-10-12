import com.xzg.wlxx.apt.EnumInnerConstantProcessor;

/**
 * @author XiaoZG
 */
module wlxx.apt {
    requires java.compiler;
    requires com.squareup.javapoet;
    requires com.google.auto.service;
    requires jdk.compiler;

    exports com.xzg.wlxx.apt;

    provides javax.annotation.processing.Processor with
            EnumInnerConstantProcessor;
}