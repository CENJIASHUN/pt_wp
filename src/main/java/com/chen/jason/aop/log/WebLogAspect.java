package com.chen.jason.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

//@Component
@Aspect
@Slf4j
public class WebLogAspect {

    //定义一个切点，表达式可以灵活运用
    @Pointcut("execution(public * com.chen.jason.controller..*.*(..))")
    public void pointCut() {

    }
    //方法执行开始之前
    @Before("pointCut()")
    public void logStart (JoinPoint joinPoint) {
        System.out.println("方法执行开始之前...参数：{"+ Arrays.asList(joinPoint.getArgs())+"}");
    }

    //方法执行开始之后
    @After("pointCut()")
    public void logEnd (JoinPoint joinPoint) {
        System.out.println("方法执行开始之后..." + joinPoint.getSignature().getName());
    }

    //当方法进行返回的时候，returning属性是指定方法参数中的result来接收返回参数，这样就可以修改返回参数
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn (JoinPoint joinPoint, Object result) {
        System.out.println("方法执行结束... 返回结果：{"+result+"}");
    }

    //当方法执行异常的时候，throwding是指定方法参数中的e来接收异常参数，可以查看发生的什么异常
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException (JoinPoint joinPoint, Exception e) {
        System.out.println("方法执行异常... 异常信息：{"+e+"}");
    }

    //环绕通知
    @Around("pointCut()")
    public Object logAround (ProceedingJoinPoint joinPoint) throws Throwable {
        //原方法执行之前会打印这个日志
        System.out.println("环绕通知...  开始");
        //执行原方法
        Object obj = joinPoint.proceed();
        //原方法执行结束，打印这行日志
        System.out.println("环绕通知...  结束");
        //返回方法返回参数
        return obj;
    }
}
