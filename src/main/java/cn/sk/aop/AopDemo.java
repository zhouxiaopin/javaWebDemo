package cn.sk.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Deseription
 * @Author zhoucp
 * @Date 2021/3/12 16:19
 */
@Component
@Aspect//为了生成代理对象
public class AopDemo {

//    相同切入点抽取
    @Pointcut(value = "execution(* cn.sk.controller.DemoController.test(..))")
    public void pointDemo(){

    }

//    前置通知
    @Before(value = "pointDemo()")
    public void before(){
        System.out.println("*****before*****");
    }
//    环绕通知
    @Around(value = "execution(* cn.sk.controller.DemoController.test(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("***环绕之前****");
//        被增强的方法执行
        joinPoint.proceed();
        System.out.println("***环绕之后****");
    }
//    （方法执行完返回值后）（有异常不执行）
    @AfterReturning(value = "execution(* cn.sk.controller.DemoController.test(..))")
    public void afterReturning(){
        System.out.println("*****afterReturning*****");
    }
    //    后置通知（有没有异常都执行）
    @After(value = "execution(* cn.sk.controller.DemoController.test(..))")
    public void after(){
        System.out.println("*****after*****");
    }
//    异常通知
    @AfterThrowing(value = "execution(* cn.sk.controller.DemoController.test(..))")
    public void afterThrowing(){
        System.out.println("*****afterThrowing*****");
    }
}
