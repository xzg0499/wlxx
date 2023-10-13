package com.xzg.wlxx.system.service.impl;

import cn.zhxu.bs.BeanSearcher;
import cn.zhxu.bs.SearchResult;
import cn.zhxu.bs.util.MapUtils;
import com.xzg.wlxx.system.service.BeanSearcherService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author XiaoZG
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BeanSearcherServiceImpl implements BeanSearcherService {

    private final BeanSearcher beanSearcher;

    @Override
    public <T> SearchResult<T> search(Class<T> cls, HttpServletRequest request) {
        return beanSearcher.search(cls, MapUtils.flat(request.getParameterMap()));
    }
}
