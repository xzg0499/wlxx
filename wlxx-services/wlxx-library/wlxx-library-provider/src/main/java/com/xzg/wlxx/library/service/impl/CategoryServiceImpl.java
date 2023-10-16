package com.xzg.wlxx.library.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.common.util.PojoConvertor;
import com.xzg.wlxx.library.mapper.CategoryMapper;
import com.xzg.wlxx.library.pojo.dto.CategoryDto;
import com.xzg.wlxx.library.pojo.po.CategoryPo;
import com.xzg.wlxx.library.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author XiaoZG
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryPo> implements CategoryService {

    @Transactional
    @Override
    public boolean batchAdd(List<CategoryDto> list) {
        var pos = PojoConvertor.toPo(CategoryPo.class, list);
        return saveBatch(pos);
    }

    @Override
    public IPage<CategoryPo> search(CategoryDto dto) {
        return page(new Page<>(dto.getPage(), dto.getSize())
                , Wrappers.<CategoryPo>lambdaQuery()
                        .orderByDesc(CategoryPo::getUpdateDate)
        );
    }
}
