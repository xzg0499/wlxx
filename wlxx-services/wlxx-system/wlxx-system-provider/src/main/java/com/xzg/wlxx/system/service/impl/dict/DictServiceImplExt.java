package com.xzg.wlxx.system.service.impl.dict;

import com.xzg.wlxx.system.service.IDictItemService;
import com.xzg.wlxx.system.service.IDictService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 数据字典扩展实现
 *
 * @author xzgan
 * @date 2023/4/10
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictServiceImplExt {
    private final IDictItemService dictItemService;

    private final IDictService dictService;
}
