package com.xzg.wlxx.system.entity.po

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import com.xzg.wlxx.common.base.BasePo
import com.xzg.wlxx.system.entity.enums.SexEnum

@TableName("emp")
data class Emp(
    @TableField("emp_code")
    var empCode: String? = null,

    @TableField("emp_name")
    var empName: String? = null,

    @TableField("sex")
    var sex: SexEnum? = null
) : BasePo<Emp>()