package com.xzg.wlxx.system.client.entity.po;


import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.common.base.BasePo;
import lombok.*;

@TableName("user")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPo extends BasePo<UserPo> {

    private String username;
    private String realName;
    private String password;
    private Long empId;
}
