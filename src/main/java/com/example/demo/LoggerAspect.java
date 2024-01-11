package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Aspect
public class LoggerAspect {

    @Pointcut("@annotation(Loggable))")
    public void loggableMethod(){  }



    //before
    @Before("loggableMethod()")
    public void beforeMethodCall(JoinPoint jp){
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(",  "));
        System.out.println(args);
    }

    //around
    @Around("loggableMethod()")
    public Object logExecuteTime(ProceedingJoinPoint jp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        String methodName =  methodSignature.getName();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            return jp.proceed();
        } finally {

            stopWatch.stop();
            System.out.println(methodName + " - Time - " + stopWatch.getTotalTimeMillis() + "ms");

        }


    }

}
