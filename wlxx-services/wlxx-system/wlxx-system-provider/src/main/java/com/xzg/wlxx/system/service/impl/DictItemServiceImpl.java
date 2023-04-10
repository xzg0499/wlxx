package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.core.base.enums.EnabledEnum;
import com.xzg.wlxx.core.exception.BusinessException;
import com.xzg.wlxx.system.client.entity.po.Dict;
import com.xzg.wlxx.system.client.entity.po.DictItem;
import com.xzg.wlxx.system.client.entity.vo.DictSeqVo;
import com.xzg.wlxx.system.mapper.DictItemMapper;
import com.xzg.wlxx.system.service.IDictItemService;
import com.xzg.wlxx.system.service.IDictService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典明细项
 *
 * @author xzgan
 * @date 2023/3/24
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem> implements IDictItemService {

    private final IDictService dictService;

    @Override
    public boolean add(DictItem po) {
        Assert.notNull(po.getDictId(), "字典ID不能为空");
        // 验证字典是否存在
        Dict dict = dictService.getById(po.getDictId());
        Assert.notNull(dict, "字典不存在");
        List<DictItem> dictItemList = lambdaQuery()
                .eq(DictItem::getDictId, po.getDictId())
                .list();
        List<DictItem> code = dictItemList.stream()
                .filter(e -> StrUtil.equals(e.getDictCode(), po.getDictCode()))
                .toList();
        if (code.size() > 0) {
            throw new BusinessException("字典编码【{}】已存在", po.getDictCode());
        }
        int max = dictItemList.stream().mapToInt(DictItem::getSort)
                .max().stream().findFirst().orElse(0);
        po.setSort(max + 1);
        return save(po);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean enabled(Long id, Boolean enabled) {
        return lambdaUpdate()
                .set(DictItem::getEnabled, enabled)
                .set(DictItem::getSort, 0)
                .eq(DictItem::getId, id)
                .update();
    }

    @Override
    public void sort(Long id) {
        List<DictSeqVo> list = baseMapper.selectHasSeq(id);
        log.info(JSONUtil.toJsonStr(list));
        List<DictItem> updateList = new ArrayList<>();
        list.forEach(e -> {
            e.setSort(e.getRownum());
            DictItem dictItem = new DictItem();
            BeanUtil.copyProperties(e, dictItem);
            updateList.add(dictItem);
        });
        updateBatchById(updateList);
        update(Wrappers.<DictItem>lambdaUpdate()
                .set(DictItem::getSort, 9999)
                .eq(DictItem::getDictId, id)
                .eq(DictItem::getEnabled, EnabledEnum.DISABLED.getCode())
        );
    }
}
