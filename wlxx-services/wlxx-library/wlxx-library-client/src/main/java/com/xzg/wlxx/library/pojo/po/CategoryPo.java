package com.xzg.wlxx.library.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xzg.wlxx.common.base.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author XiaoZG
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("category")
public class CategoryPo extends BasePo<CategoryPo> {


    private String categoryCode;
    private String categoryName;
    private Long categoryId;
    private Integer categoryLevel;
    private String description;
}
