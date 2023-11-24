package dev.Innocent.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAOP {
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* dev.Innocent.Controller.*.*(..))")
    private void forControllerPackage(){}
}
