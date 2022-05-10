package com.example.bankingsystem.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggerAspect {
    @Pointcut("execution(* com.example.bankingsystem.api.*.*(*))")
     public void pd1()
    {

    }
    @Pointcut("execution(* com.example.bankingsystem.services.*.*(*))")
    public void pd2()
    {

    }


    @After("pd1()")
    public void doLogs(JoinPoint jp){
       log.info("Method called JP {}",jp);
//        System.out.println(jp.getTarget());
//        Arrays.stream(jp.getArgs()).forEach(System.out::println);


    }
}
