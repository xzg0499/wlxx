package com.xzg.wlxx.web.aspect;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        List<Object> param = new ArrayList<>();
        // 剔除无法序列化参数
        for (Object arg : args) {
            if (Objects.nonNull(arg) && arg instanceof MultipartFile) {
                param.add(arg);
            }
        }
        log.info("doBefore:{}", JSONUtil.toJsonStr(param));
    }

    @After("logPoint()")
    public void doAfter(JoinPoint joinPoint) {
        log.warn("doAfter");
    }

    @AfterReturning(returning = "obj", pointcut = "logPoint()")
    public void doReturning(Object obj) {
        log.info("doReturning:{}", JSONUtil.toJsonStr(obj));
    }

    @AfterThrowing(pointcut = "logPoint()")
    public void doThrowing() {
        log.warn("doThrowing");
    }

    @Around("logPoint()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
//        log.info("doAround：{}", JSONUtil.toJsonStr(args));
        return point.proceed();
    }
}
