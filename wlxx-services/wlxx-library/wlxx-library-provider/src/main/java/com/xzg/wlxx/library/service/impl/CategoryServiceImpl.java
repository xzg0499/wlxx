package com.xzg.wlxx.library.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.common.util.PojoConvertor;
import com.xzg.wlxx.library.listener.CategoryListener;
import com.xzg.wlxx.library.mapper.CategoryMapper;
import com.xzg.wlxx.library.pojo.dto.CategoryDto;
import com.xzg.wlxx.library.pojo.po.CategoryPo;
import com.xzg.wlxx.library.service.CategoryService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
        return saveOrUpdateBatch(pos);
    }

    @Override
    public IPage<CategoryPo> search(CategoryDto dto) {
        return page(new Page<>(dto.getPage(), dto.getSize())
                , Wrappers.<CategoryPo>lambdaQuery()
                        .orderByDesc(CategoryPo::getUpdateDate)
        );
    }

    @Override
    public void exportExcel(CategoryDto dot, HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("图书分类", StandardCharsets.UTF_8)
                .replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        var list = list();
        EasyExcel.write(response.getOutputStream(), CategoryPo.class)
                .sheet("模板").doWrite(list);
    }

    @Override
    public boolean importExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), CategoryPo.class, new CategoryListener()).doReadAll();
        return true;
    }
}
