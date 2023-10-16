package com.xzg.wlxx.library.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xzg.wlxx.library.pojo.dto.BooksDto;
import com.xzg.wlxx.library.pojo.po.BooksPo;

import java.util.List;

/**
 * @author XiaoZG
 */
public interface BooksService extends IService<BooksPo> {

    boolean batchAdd(List<BooksDto> list);

    IPage<BooksPo> search(BooksDto dto);
}
