package com.endava.training.spring.demo.aop;

import com.endava.training.spring.demo.exception.MyException;
import com.endava.training.spring.demo.service.MyService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by vsafronovici on 3/20/2017.
 */
@Aspect
@Component
public class AppLogger {


    @Pointcut("execution(* com.endava.training.spring.demo.service.*.*(..))")
    public void pcAllServiceMethods() {
    }

    @Pointcut("@annotation(com.endava.training.spring.demo.annot.MyAnnotation)")
    public void pcAnnotated() {
    }


    @Around("pcAllServiceMethods()")
    public Object aroundAllActions(ProceedingJoinPoint joinPoint) throws Throwable {

        /*
         * Look at getTarget() vs getThis()
         */

        String methodName = joinPoint.getSignature().getName();

        if (joinPoint.getThis() instanceof MyService) {

            if (methodName.equals("save")) {
                Integer id = (Integer) joinPoint.getArgs()[0];
                System.out.println(String.format("========== saving user %s", id));

                /*
                 * Could be stored in another DB or send to a Web Service
                 */
            }
        }


        long begin = System.currentTimeMillis();
        Object ret = joinPoint.proceed();
        long end = System.currentTimeMillis();

        System.out.println(String.format("++++++++++++++++++++ %s.%s() executed in %d millis", joinPoint.getTarget().getClass(), methodName, (end - begin)));

        return ret;

    }

    @Around("pcAnnotated()")
    public void aroundAnnotated(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("================ MyAnntation works ======================");
        Integer id = (Integer) joinPoint.getArgs()[0];
        if (id <= 0) {
            throw new MyException("Invalid Id provided");
        }
        joinPoint.proceed();

    }


}
