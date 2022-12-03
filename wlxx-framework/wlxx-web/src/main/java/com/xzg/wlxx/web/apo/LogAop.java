package com.xzg.wlxx.web.apo;

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
public class LogAop {

    @Pointcut("@annotation(com.xzg.wlxx.web.apo.Log)")
    public void logPoint() {
    }

    @Before("logPoint()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("doBefore");
    }

    @After("logPoint()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("doAfter");
    }

    @AfterReturning(returning = "obj", pointcut = "logPoint()")
    public void doReturning(Object obj) {
        log.info("doReturning");
    }

    @AfterThrowing(pointcut = "logPoint()")
    public void doThrowing() {
        log.info("doThrowing");
    }

    @Around("logPoint()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        log.info("doAround");
        return point.proceed();
    }
}
