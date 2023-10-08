package com.xzg.wlxx.system.client.entity.po

import com.baomidou.mybatisplus.annotation.TableName
import com.xzg.wlxx.common.base.BasePo
import lombok.*

@TableName("user")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
data class UserPo(
    var username: String? = null,
    var realName: String? = null,
    var password: String? = null,
    var empId: Long? = null
) : BasePo<UserPo?>()
