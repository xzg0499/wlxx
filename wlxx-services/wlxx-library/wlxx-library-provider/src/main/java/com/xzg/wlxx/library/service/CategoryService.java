package com.xzg.wlxx.library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.library.pojo.dto.CategoryDto;
import com.xzg.wlxx.library.pojo.po.CategoryPo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author XiaoZG
 */
public interface CategoryService extends IService<CategoryPo> {

    boolean batchAdd(List<CategoryDto> list);

    IPage<CategoryPo> search(CategoryDto dto);

    void exportExcel(CategoryDto dot, HttpServletResponse response) throws IOException;

    boolean importExcel(MultipartFile file) throws IOException;
}
