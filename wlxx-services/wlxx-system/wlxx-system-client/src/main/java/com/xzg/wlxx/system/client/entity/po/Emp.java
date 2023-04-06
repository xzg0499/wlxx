package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
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
@TableName("t_emp")
@Schema(description = "Employee对象")
public class Emp extends BasePo<Emp> {

    private static final long serialVersionUID = 1L;

    @Schema(description = "是否启用")
    @TableField("is_enabled")
    private Boolean isEnabled;

    @Schema(description = "员工编号")
    @TableField("emp_code")
    private String empCode;

    @Schema(description = "姓名")
    @TableField("emp_name")
    private String empName;


}
