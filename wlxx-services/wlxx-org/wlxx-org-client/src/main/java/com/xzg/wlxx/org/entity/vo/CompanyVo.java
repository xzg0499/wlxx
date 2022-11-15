package com.xzg.wlxx.org.entity.vo;

import com.xzg.wlxx.org.entity.po.CompanyPo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.org.entity.vo
 * @date 2022/11/12 14:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyVo extends CompanyPo {


    @ApiModelProperty("下级公司")
    private List<CompanyVo> children;
}
