package com.xzg.wlxx.module.common.ctrl;


import com.xzg.wlxx.module.common.entity.TDict;
import com.xzg.wlxx.framework.ctrl.BaseCtrl;
import com.xzg.wlxx.framework.model.AjaxResult;
import com.xzg.wlxx.framework.utils.BasicUtils;
import com.xzg.wlxx.module.common.service.ITDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzgang
 * @since 2021-05-05
 */
@RestController
@RequestMapping("/framework/t-dict")
public class TDictController extends BaseCtrl {
    @Autowired
    ITDictService itDictService;

    /*
    TODO 字典表，字典新增，字典修改，字典删除，字典查询
    字典新增：code不能重复，可以采用数据库unique来做
     */

    @PostMapping("/queryDict")
    public AjaxResult queryDict(){
        List<TDict> dicts = itDictService.select();
        return success(dicts);
    }

    @PostMapping("/addDict")
    public AjaxResult addDict(@RequestBody TDict dict){
        dict.setId(BasicUtils.getUUID());
        //TODO 通过实现model来调用curd方法，未实现？
        boolean flag = dict.insert();
        return success(flag);
    }

    @PostMapping("/updateDict")
    public AjaxResult updateDict(@RequestBody TDict dict){
        boolean flag = itDictService.updateById(dict);
        return success(flag);
    }

    @PostMapping("/deleteDict")
    public AjaxResult deleteDict(@RequestBody List<String> ids){
        boolean flag = itDictService.removeByIds(ids);
        return success(flag);
    }
}
