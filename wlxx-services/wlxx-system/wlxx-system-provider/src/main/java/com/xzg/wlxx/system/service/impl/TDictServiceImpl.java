package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.common.core.exception.BusinessException;
import com.xzg.wlxx.system.client.entity.TDict;
import com.xzg.wlxx.system.mapper.TDictMapper;
import com.xzg.wlxx.system.service.ITDictService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzg
 * @since 2022-01-16
 */
@Service
public class TDictServiceImpl extends ServiceImpl<TDictMapper, TDict> implements ITDictService {

    @Override
    public Boolean add(TDict dict) throws Exception{
        validate(dict);

        return save(dict);
    }

    /**
     * TODO 新增、更新校验？
     * 校验
     * @param dict
     * @return
     * @throws NullPointerException
     */
    public Boolean validate(TDict dict) throws BusinessException{
        if(StrUtil.isBlank(dict.getDictCode())){
            throw new BusinessException("字典编码必填");
        }

        return true;
    }


    @Override
    public Boolean modify(TDict dict) throws Exception {
        validate(dict);


        return updateById(dict);
    }


    @Override
    public IPage<TDict> query(TDict dict) throws Exception {
        return page(new Page<>(dict.getPageNo(),dict.getPageSize()),new LambdaQueryWrapper<>());
    }

    @Override
    public TDict getByCode(String code) throws Exception {
        TDict dict = lambdaQuery().select().eq(StrUtil.isNotBlank(code),TDict::getDictCode,code).one();
        return dict;
    }

    /**
     * TODO 级联删除子项
     * TODO Boolean返回再controller无法判断成败与否
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Boolean delById(String id) throws Exception {
        TDict dict = getById(id);



        return removeById(id);
    }

    public Boolean isDel(String id) throws Exception{



        return true;
    }
}
