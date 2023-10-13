package com.xzg.wlxx.system.client.entity.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.common.base.BasePo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("emp")
@Data
@EqualsAndHashCode(callSuper = true)
public class EmpPo extends BasePo<EmpPo> {

    @TableField("emp_code")
    @NotBlank(message = "不能为空")
    private String empCode;

    @TableField("emp_name")
    @NotBlank(message = "不能为空")
    private String empName;

    private Long orgId;
}
