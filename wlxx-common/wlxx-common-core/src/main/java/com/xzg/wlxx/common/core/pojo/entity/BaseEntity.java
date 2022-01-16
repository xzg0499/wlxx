package com.xzg.wlxx.common.core.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author xzgang0499
 * @date 2021-12-27
 * @since jdk1.8
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEntity<T extends Model<?>> extends Model<T> {

    @ApiModelProperty("创建者")
    private String creator;
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    @ApiModelProperty("更新人")
    private String updater;
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("主键")
//    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @TableField(exist = false)
    @ApiModelProperty("页码")
    private Integer pageNo;
    @TableField(exist = false)
    @ApiModelProperty("一页多少")
    private Integer pageSize;
}
