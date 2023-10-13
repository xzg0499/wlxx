package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.common.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoZG
 */
@TableName("tenant")
@Data
@EqualsAndHashCode(callSuper = true)
public class TenantPo extends BasePo<TenantPo> {

    private String tenantName;
}
