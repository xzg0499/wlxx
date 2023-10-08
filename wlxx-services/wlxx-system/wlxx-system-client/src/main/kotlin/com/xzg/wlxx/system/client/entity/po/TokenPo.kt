package com.xzg.wlxx.system.client.entity.po

import com.baomidou.mybatisplus.annotation.TableName
import com.xzg.wlxx.common.base.BasePo
import lombok.*

/**
 * @author XiaoZG
 */
@TableName("token")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
class TokenPo(
    var token: String? = null,
    var expired: Boolean? = null,
    var revoked: Boolean? = null,
    var userId: Long? = null
) : BasePo<TokenPo?>()
