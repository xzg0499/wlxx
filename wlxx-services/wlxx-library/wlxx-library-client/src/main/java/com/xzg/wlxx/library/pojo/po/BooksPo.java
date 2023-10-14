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
@TableName("books")
public class BooksPo extends BasePo<BooksPo> {

    private Integer category;
    private String booksName;
    private String booksSite;
    private String coverImg;
    private String author;
    private String description;
    private String briefIntroduction;

}
