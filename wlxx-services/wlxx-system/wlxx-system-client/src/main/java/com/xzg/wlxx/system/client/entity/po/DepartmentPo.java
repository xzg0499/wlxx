package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门
 * </p>
 *
 * @author xzgan
 * @since 2022-11-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_department")
@ApiModel(value = "Department对象", description = "部门")
public class DepartmentPo extends BasePo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "是否启用")
    @TableField("is_enabled")
    private Boolean isEnabled;

    @ApiModelProperty(value = "部门编码")
    @TableField("dept_code")
    private String deptCode;

    @ApiModelProperty(value = "部门名称")
    @TableField("dept_name")
    private String deptName;

    @ApiModelProperty(value = "级别")
    @TableField("level")
    private Integer level;

    @ApiModelProperty(value = "上级部门")
    @TableField("parent_dept_id")
    private Long parentDeptId;


}
