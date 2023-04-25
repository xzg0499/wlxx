package com.xzg.wlxx.system.client.entity.vo;

import cn.hutool.core.bean.copier.BeanCopier;
import cn.hutool.core.bean.copier.CopyOptions;

/**
 * @author xzgan
 * @date 2023/4/20
 */
public class DemoBeanCopier {

    public static void main(String[] args) {
        Po p = new Po();
        p.setName("xzg");
        p.setId(0L);
        Vo v = new Vo();
        BeanCopier.create(p, v, CopyOptions.create()).copy();
        System.out.println(v);
    }
}
