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
 * 员工
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_employee")
@ApiModel(value = "Employee对象", description = "员工")
public class EmployeePo extends BasePo<EmployeePo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "是否启用")
    @TableField("is_enabled")
    private Boolean isEnabled;

    @ApiModelProperty(value = "员工编号")
    @TableField("emp_code")
    private String empCode;

    @ApiModelProperty(value = "姓名")
    @TableField("emp_name")
    private String empName;


}
