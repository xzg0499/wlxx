package com.xzg.wlxx.system.client.entity.vo;

import com.xzg.wlxx.system.client.entity.po.OrgPo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrgVo extends OrgPo {

    private List<OrgVo> children;
}
