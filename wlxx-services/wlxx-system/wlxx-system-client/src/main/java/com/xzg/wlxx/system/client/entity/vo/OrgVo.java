package com.xzg.wlxx.system.client.entity.vo;

import com.xzg.wlxx.system.client.entity.po.Org;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrgVo extends Org {

    private List<OrgVo> children;
}
