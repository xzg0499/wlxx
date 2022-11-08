package com.xzg.wlxx.common.core.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ejlchina.searcher.MapSearcher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xzgan
 * @since 2022/9/4
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M,T> implements BaseIService<T> {


}
