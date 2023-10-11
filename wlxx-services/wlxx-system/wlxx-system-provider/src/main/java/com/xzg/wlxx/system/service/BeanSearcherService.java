package com.xzg.wlxx.system.service;

import cn.zhxu.bs.SearchResult;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author XiaoZG
 */
public interface BeanSearcherService {

    <T> SearchResult<T> search(Class<T> cls, HttpServletRequest request);
}
