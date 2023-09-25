package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.common.base.BasePo;
import lombok.*;

/**
 * @author XiaoZG
 */
@TableName("token")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenPo extends BasePo<TokenPo> {

    private String token;
    private Boolean expired;
    private Boolean revoked;
    private Long userId;
}
