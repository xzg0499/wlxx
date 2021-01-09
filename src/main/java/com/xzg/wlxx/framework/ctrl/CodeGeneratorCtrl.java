package com.xzg.wlxx.framework.ctrl;

import com.xzg.wlxx.framework.base.BaseCtrl;
import com.xzg.wlxx.framework.generator.CodeGenerator;
import com.xzg.wlxx.framework.generator.GeneratorDto;
import com.xzg.wlxx.framework.model.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 肖志刚
 * @Date: 2020/7/5 0:27
 */
@RestController
public class CodeGeneratorCtrl extends BaseCtrl{
    @Autowired
    private CodeGenerator codeGenerator;
    /**
     * 代码生成接口
     * TODO 接口待完善
     * @param param
     * @return
     */
    @PostMapping("/generator")
    @ResponseBody
    public AjaxResult generator(@RequestBody  GeneratorDto param) throws Exception{
        return success("代码生成成功！",codeGenerator.executeGenerator(param));
    }
    @PostMapping("/getTables")
    @ResponseBody
    public AjaxResult getTables(){
        return success();
    }
}
