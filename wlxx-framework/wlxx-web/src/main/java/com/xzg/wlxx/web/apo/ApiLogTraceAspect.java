package com.xzg.wlxx.web.apo;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author xzgan
 * @project wlxx
 * @package com.xzg.wlxx.web.apo
 * @date 2022/12/3 15:27
 */
@Component
@Slf4j
@Aspect
public class ApiLogTraceAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)" +
            "||" +
            "@annotation(org.springframework.web.bind.annotation.GetMapping)" +
            "||" +
            "@annotation(org.springframework.web.bind.annotation.PutMapping)" +
            "||" +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping)" +
            "||" +
            "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void logPoint() {
    }

    @Before("logPoint()")
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("doBefore:{}", JSONUtil.toJsonStr(args));
    }

    @After("logPoint()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("doAfter");
    }

    @AfterReturning(returning = "obj", pointcut = "logPoint()")
    public void doReturning(Object obj) {
        log.info("doReturning:{}", JSONUtil.toJsonStr(obj));
    }

    @AfterThrowing(pointcut = "logPoint()")
    public void doThrowing() {
        log.info("doThrowing");
    }

    @Around("logPoint()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
//        log.info("doAround：{}", JSONUtil.toJsonStr(args));
        return point.proceed(args);
    }
}
