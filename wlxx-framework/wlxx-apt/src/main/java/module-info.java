import com.xzg.wlxx.apt.EnumInnerConstantProcessor;

/**
 * @author XiaoZG
 */
module wlxx.apt {
    requires java.compiler;
    requires com.squareup.javapoet;
    requires com.google.auto.service;
    requires jdk.compiler;
    requires cn.hutool;
    requires lombok;

    exports com.xzg.wlxx.apt;

    opens com.xzg.wlxx.apt;

    uses EnumInnerConstantProcessor;

    provides javax.annotation.processing.Processor with
            EnumInnerConstantProcessor;
}