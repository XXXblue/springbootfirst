package com.xjy.springbootfirst.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @Author: XBlue
 * @Date: Create in 2018/6/120:35
 * @Description:
 * @Modified By:
 */
@Aspect
@Component
public class HttpAspect {

    private final static String START_TIME = "strat_time";

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.xjy.springbootfirst.controller.HelloController.ok(..))")
    public void log(){

    }
    @Before("log()")
    public void before(JoinPoint joinPoint){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        request.setAttribute(START_TIME,System.currentTimeMillis());
        logger.info("before");
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("method={}",request.getMethod());
        //之前是controller，之后是方法名
        logger.info("classmethod={}",joinPoint.getSignature().getDeclaringTypeName()+"-"+joinPoint.getSignature().getName());
        //传入的参数是什么
        logger.info("arg={}",joinPoint.getArgs());
    }

    @After("log()")
    public void after(){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        logger.info(System.currentTimeMillis()-(Long) request.getAttribute(START_TIME)+"");
        logger.info("after");

    }
}
