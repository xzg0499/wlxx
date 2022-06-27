package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.common.core.exception.BusinessException;
import com.xzg.wlxx.system.client.entity.TDict;
import com.xzg.wlxx.system.client.entity.TDictItem;
import com.xzg.wlxx.system.mapper.TDictItemMapper;
import com.xzg.wlxx.system.service.ITDictItemService;
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
public class TDictItemServiceImpl extends ServiceImpl<TDictItemMapper, TDictItem> implements ITDictItemService {


    @Override
    public Boolean add(TDictItem dictItem) throws Exception {
        validate(dictItem);

        return save(dictItem);
    }

    /**
     * TODO 更新、插入校验分开校验
     * @param dictItem
     * @return
     * @throws BusinessException
     */
    public Boolean validate(TDictItem dictItem) throws BusinessException{
        if(StrUtil.isBlank(dictItem.getDictCode())){
            throw new BusinessException("请输入字典编码！");
        }
        if(StrUtil.isBlank(dictItem.getDictId())){
            throw new BusinessException("请输入上级ID");
        }
        // TODO 校验上级编码问题
        TDict dict = new TDict();
        dict.setId(dictItem.getDictId());
        dict = dict.selectById();
        if(dict == null || StrUtil.isBlank(dict.getDictCode())){
            throw new BusinessException("上级编码不存在");
        }


        return true;
    }

    @Override
    public Boolean modify(TDictItem dictItem) throws Exception {
        validate(dictItem);

        return updateById(dictItem);
    }

    @Override
    public IPage<TDictItem> query(TDictItem dictItem) throws Exception {
        return page(new Page<>(dictItem.getPageNo(),dictItem.getPageSize()),new LambdaQueryWrapper<>());
    }

    @Override
    public TDictItem getByCode(String code) throws Exception {
        TDictItem dictItem = lambdaQuery().eq(StrUtil.isNotBlank(code),TDictItem::getDictCode,code).one();
        return dictItem;
    }
}
