package com.xzg.wlxx.module.framework.ctrl;


import com.xzg.wlxx.framework.model.CtrlResult;
import com.xzg.wlxx.module.framework.entity.TDict;
import com.xzg.wlxx.framework.ctrl.BaseCtrl;
import com.xzg.wlxx.framework.utils.BasicUtils;
import com.xzg.wlxx.module.framework.service.ITDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public CtrlResult<List<TDict>> queryDict(){
        List<TDict> dicts = itDictService.select();
        return success(dicts);
    }

    @PostMapping("/addDict")
    public CtrlResult addDict(@RequestBody TDict dict){
        dict.setId(BasicUtils.getUUID());
        boolean flag = dict.insert();
        return success(flag);
    }

    @PutMapping("/updateDict")
    public CtrlResult updateDict(@RequestBody TDict dict){
        boolean flag = dict.updateById();
        return success(flag);
    }

    @DeleteMapping("/deleteDict")
    public CtrlResult<Boolean> deleteDict(@RequestBody List<String> ids){
        boolean flag = itDictService.removeByIds(ids);
        return success(flag);
    }

    @GetMapping("/get")
    public CtrlResult<TDict> getById(@RequestParam("id")String id){
        return success(itDictService.getById(id));
    }
}
