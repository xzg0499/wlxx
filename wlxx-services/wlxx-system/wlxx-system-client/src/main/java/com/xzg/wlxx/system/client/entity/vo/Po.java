package com.xzg.wlxx.system.client.entity.vo;

import com.xzg.wlxx.core.base.domain.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xzgan
 * @date 2023/4/20
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Po extends BasePo<Po> {

    private String name;
}
