package com.xzg.wlxx.library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.library.pojo.dto.CategoryDto;
import com.xzg.wlxx.library.pojo.po.CategoryPo;

import java.util.List;

/**
 * @author XiaoZG
 */
public interface CategoryService extends IService<CategoryPo> {

    boolean batchAdd(List<CategoryDto> list);

    IPage<CategoryPo> search(CategoryDto dto);
}
