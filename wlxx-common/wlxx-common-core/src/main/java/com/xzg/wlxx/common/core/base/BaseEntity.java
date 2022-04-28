package com.xzg.wlxx.common.core.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @ApiModelProperty("更新人")
    private String updater;
    @ApiModelProperty("更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @ApiModelProperty("主键")
//    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

}
