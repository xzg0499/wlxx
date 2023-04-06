package com.xzg.wlxx.system.client.entity.vo;

import com.xzg.wlxx.system.client.entity.po.Org;
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
public class OrgVo extends Org {

    @Schema(description = "子级组织")
    private List<OrgVo> children;
}
