package com.cy.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ClassName:TimeAspect
 * Package:com.cy.store.aop
 * Description
 *
 * @Author:@wenxueshi
 * @Create:2023/1/10 - 21:56
 * @Version:v1.0
 * 统计业务方法执行时长
 */
@Component//交给spring容器管理
@Aspect//表明这是一个切面类
public class TimeAspect {
    //公共的切入点表达式(方便重复使用)
    @Pointcut("execution(* com.cy.store.service.impl.*.*(..))")
    public void pointcut(){
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //开始时间
        long start = System.currentTimeMillis();
        //调用目标方法,比如login方法,getByUid方法
        Object proceed = joinPoint.proceed();
        //结束时间
        long end = System.currentTimeMillis();
        System.out.println("耗时~"+(end-start));
        return proceed;
    }
}
