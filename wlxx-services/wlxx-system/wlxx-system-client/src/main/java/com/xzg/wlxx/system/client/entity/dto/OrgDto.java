package com.xzg.wlxx.system.client.entity.dto;

import com.xzg.wlxx.system.client.entity.po.OrgPo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoZG
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name = "组织接口参数")
public class OrgDto extends OrgPo {
}
