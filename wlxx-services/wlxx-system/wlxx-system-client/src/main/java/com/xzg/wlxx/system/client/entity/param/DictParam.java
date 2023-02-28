package com.xzg.wlxx.system.client.entity.param;

import com.xzg.wlxx.core.base.domain.dto.PageParam;
import com.xzg.wlxx.system.client.entity.po.DictPo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 数据字典分页查询参数
 *
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.system.client.entity.param
 * @date 2022/12/3 14:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DictParam extends PageParam<DictPo> {
}
