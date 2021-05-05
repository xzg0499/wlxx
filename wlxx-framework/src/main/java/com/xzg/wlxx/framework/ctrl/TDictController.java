package com.xzg.wlxx.framework.ctrl;


import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.xzg.wlxx.framework.entity.TDict;
import com.xzg.wlxx.framework.model.AjaxResult;
import com.xzg.wlxx.framework.service.ITDictService;
import com.xzg.wlxx.framework.utils.BasicUtils;
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

    @PostMapping("/queryDict")
    public AjaxResult queryDict(){
        List<TDict> dicts = itDictService.select();
        return success(dicts);
    }

    @PostMapping("/addDict")
    public AjaxResult addDict(@RequestBody TDict dict){
        dict.setId(BasicUtils.getUUID());
        boolean flag = itDictService.save(dict);
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
