package com.xzg.wlxx.system.aspect

import cn.hutool.json.JSONUtil
import com.xzg.wlxx.common.log.WlxxLog.Companion.log
import lombok.extern.slf4j.Slf4j
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.web.multipart.MultipartFile
import java.util.*

/**
 * @author XiaoZG
 */
//@Component
@Slf4j //@Aspect

class LogAspect {
    @Pointcut(
        """
            @annotation(org.springframework.web.bind.annotation.PostMapping)
            || @annotation(org.springframework.web.bind.annotation.GetMapping)
            || @annotation(org.springframework.web.bind.annotation.PutMapping)
            || @annotation(org.springframework.web.bind.annotation.DeleteMapping)
            || @annotation(org.springframework.web.bind.annotation.RequestMapping)
            
            """
    )
    fun logPoint() {
    }

    @Before("logPoint()")
    fun doBefore(joinPoint: JoinPoint) {
        val args = joinPoint.args
        val param: MutableList<Any> = ArrayList()
        // 剔除无法序列化参数
        for (arg in args) {
            if (Objects.nonNull(arg) && arg !is MultipartFile) {
                param.add(arg)
            }
        }
        log.info("doBefore:{}", JSONUtil.toJsonStr(param))
    }

    //    @After("logPoint()")
    //    public void doAfter(JoinPoint joinPoint) {
    //        log.warn("doAfter");
    //    }
    @AfterReturning(returning = "obj", pointcut = "logPoint()")
    fun doReturning(obj: Any?) {
        log.info("doReturning:{}", JSONUtil.toJsonStr(obj))
    } //    @AfterThrowing(pointcut = "logPoint()")
    //    public void doThrowing() {
    //        log.warn("doThrowing");
    //    }
    //    @Around("logPoint()")
    //    public Object doAround(ProceedingJoinPoint point) throws Throwable {
    //        Object[] args = point.getArgs();
    ////        log.info("doAround：{}", JSONUtil.toJsonStr(args));
    //        return point.proceed();
    //    }
}
