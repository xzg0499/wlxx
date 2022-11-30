package com.xzg.wlxx.system.client.entity.param;

import com.xzg.wlxx.core.base.domain.dto.PageParam;
import com.xzg.wlxx.system.client.entity.po.UserPo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.system.client.entity.param
 * @date 2022/11/30 22:52
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserParam extends PageParam<UserPo> {
}
