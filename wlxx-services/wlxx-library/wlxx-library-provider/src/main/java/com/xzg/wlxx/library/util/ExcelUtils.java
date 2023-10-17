package com.xzg.wlxx.library.util;

import com.alibaba.excel.EasyExcel;
import com.xzg.wlxx.common.base.BasePo;
import com.xzg.wlxx.library.listener.ExcelSimpleListener;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author XiaoZG
 */
public class ExcelUtils {


    public static <T extends BasePo<T>> void doRead(MultipartFile file, Class<T> cls) {
        try {
            EasyExcel.read(file.getInputStream(), cls, new ExcelSimpleListener<>(cls))
                    .doReadAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
