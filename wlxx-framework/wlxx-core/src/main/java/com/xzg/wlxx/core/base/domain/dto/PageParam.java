package com.xzg.wlxx.core.base.domain.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.core.base.domain.dto
 * @date 2022/11/11 15:44
 */
@Data
@Api(value = "分页参数", tags = "分页参数")
public class PageParam<T> {

    @ApiModelProperty("当前页")
    private Integer current = 0;

    @ApiModelProperty("每页条数")
    private Integer size = 10;

    public IPage<T> getPage() {
        IPage<T> page = new Page<T>(this.current, this.size);
        return page;
    }
}
