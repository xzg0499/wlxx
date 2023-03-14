package com.xzg.wlxx.system.client.entity.vo;

import com.xzg.wlxx.system.client.entity.po.OrganizationPo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.system.client.entity.vo
 * @date 2022/11/30 17:15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrganizationVo extends OrganizationPo {

    @Schema(description = "子级组织")
    private List<OrganizationVo> children;
}
