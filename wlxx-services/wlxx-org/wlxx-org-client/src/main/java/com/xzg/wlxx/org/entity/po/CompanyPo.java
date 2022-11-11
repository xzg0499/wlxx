package com.xzg.wlxx.org.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 组织
 * </p>
 *
 * @author xzgan
 * @since 2022-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_company")
@ApiModel(value = "Company对象", description = "组织")
public class CompanyPo extends BasePo<CompanyPo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "是否启用")
    @TableField("is_enabled")
    private Boolean isEnabled;

    @ApiModelProperty(value = "公司编码")
    @NotEmpty(message = "公司编码不能为空")
    @TableField("company_code")
    private String companyCode;

    @ApiModelProperty(value = "公司名称")
    @NotEmpty(message = "公司名称不能为空")
    @TableField("company_name")
    private String companyName;

    @ApiModelProperty(value = "公司级别")
    @TableField("level")
    private Integer level;

    @ApiModelProperty(value = "上级公司")
    @TableField("parent_company_id")
    private Integer parentCompanyId;


}
