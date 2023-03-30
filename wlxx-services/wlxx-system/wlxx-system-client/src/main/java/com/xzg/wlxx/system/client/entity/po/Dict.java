package com.xzg.wlxx.system.client.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.core.base.domain.po.BasePo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author xzgan
 * @since 2022-11-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_dict")
@Schema(description = "Dict对象")
@NoArgsConstructor
public class Dict extends BasePo<Dict> {

    @Schema(description = "字典编码")
    private String dictCode;

    @Schema(description = "字典名称")
    private String dictName;

    @Schema(description = "是否启用")
    private Boolean enabled;

    @Schema(description = "描述")
    private String remark;

    @Schema(description = "层级")
    private Integer levels;

    @Builder
    private Dict(Long id, Long creator, Long createTime, Long updater, Long updateTime, Integer deleted, String dictCode, String dictName, Boolean enabled, String remark, Integer levels) {
        super(id, creator, createTime, updater, updateTime, deleted);
        this.dictCode = dictCode;
        this.dictName = dictName;
        this.enabled = enabled;
        this.remark = remark;
        this.levels = levels;
    }
}
