package com.xzg.wlxx.library.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.common.util.PojoConvertor;
import com.xzg.wlxx.library.mapper.BooksMapper;
import com.xzg.wlxx.library.pojo.dto.BooksDto;
import com.xzg.wlxx.library.pojo.po.BooksPo;
import com.xzg.wlxx.library.service.BooksService;
import com.xzg.wlxx.library.util.ExcelUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author XiaoZG
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class BooksServiceImpl extends ServiceImpl<BooksMapper, BooksPo> implements BooksService {

    @Transactional
    @Override
    public boolean batchAdd(List<BooksDto> list) {
        var pos = PojoConvertor.toPo(BooksPo.class, list);
        return saveBatch(pos);
    }

    @Override
    public IPage<BooksPo> search(BooksDto dto) {
        return page(new Page<>(dto.getPage(), dto.getSize())
                , Wrappers.<BooksPo>lambdaQuery().orderByDesc(BooksPo::getUpdateDate)
        );
    }

    @Override
    public boolean importExcel(MultipartFile file) {
        return ExcelUtils.doRead(file, BooksPo.class);
    }
}
