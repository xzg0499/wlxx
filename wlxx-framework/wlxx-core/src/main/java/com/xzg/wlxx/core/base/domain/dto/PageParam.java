package com.xzg.wlxx.core.base.domain.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.core.base.domain.dto
 * @date 2022/11/11 15:44
 */
@Data
@Schema(description = "分页参数")
public class PageParam<T> {

    @Schema(description = "当前页")
    private Integer current = 0;

    @Schema(description = "每页条数")
    private Integer size = 10;

    @Schema(hidden = true)
    public IPage<T> getPage() {
        IPage<T> page = new Page<T>(this.current, this.size);
        return page;
    }
}
