package com.xzg.wlxx.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzg.wlxx.core.exception.BusinessException;
import com.xzg.wlxx.system.client.entity.po.Dict;
import com.xzg.wlxx.system.client.entity.po.DictItem;
import com.xzg.wlxx.system.mapper.DictItemMapper;
import com.xzg.wlxx.system.service.IDictItemService;
import com.xzg.wlxx.system.service.IDictService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        validate4Add(po);
        // 验证字典是否存在
        Dict dict = dictService.getById(po.getDictId());
        if (dict == null) {
            throw new BusinessException("字典不存在");
        }
        List<DictItem> dictItemList = lambdaQuery()
                .eq(DictItem::getDictId, po.getDictId())
                .list();
        List<DictItem> code = dictItemList.stream()
                .filter(e -> StrUtil.equals(e.getDictCode(), po.getDictCode()))
                .toList();
        if (code.size() > 0) {
            throw new BusinessException("字典编码{}已存在", po.getDictCode());
        }
        int max = dictItemList.stream().mapToInt(DictItem::getSort)
                .max().stream().findFirst().orElse(0);
        po.setSort(max + 1);
        return save(po);
    }

    public void validate4Add(DictItem po) {
        if (Objects.isNull(po.getDictId())) {
            throw new BusinessException("字典ID不能为空");
        }
    }
}
