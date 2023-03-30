package com.xzg.wlxx.system.client.entity.vo;

import com.xzg.wlxx.system.client.entity.po.DictItem;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 带序号的查询
 *
 * @author xzgan
 * @date 2023/3/28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "带序号的查询")
@NoArgsConstructor
public class DictSeqVo extends DemoBaseVo<DictItem> {

    @Schema(description = "序号")
    private Integer rownum;


    /**
     * 父类Builder构造器实现
     */
    @Builder
    private DictSeqVo(Integer rownum, String name) {
        super(name);
        this.rownum = rownum;
    }
}
