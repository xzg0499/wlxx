package com.xzg.wlxx.system.client.entity.po

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import com.xzg.wlxx.common.base.BasePo
import lombok.Data
import lombok.EqualsAndHashCode

@TableName("emp")
@Data
@EqualsAndHashCode(callSuper = true)
data class EmpPo(
    @TableField("emp_code")
    var empCode: String? = null,

    @TableField("emp_name")
    var empName: String? = null,
    var orgId: Long? = null
) : BasePo<EmpPo?>()
