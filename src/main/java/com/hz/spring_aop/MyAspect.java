package com.hz.spring_aop;

import com.hz.spring_aop.domain.SysUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Date;

@Aspect
public class MyAspect {

    @Before(value = "execution(public * doS*(..))")
    public static void doLog(JoinPoint jp){

        /*System.out.println("方法的定义：" + jp.getSignature());
        System.out.println("方法的名称：" + jp.getSignature().getName());
        Object[] args = jp.getArgs();
        for (Object o : args){
            System.out.println("参数 = " + o);
        }*/
        System.out.println("前置方法：目标方法执行时间：" + new Date());
    }

    @AfterReturning(value = "execution(public * doO*(..))",returning = "res")
    public static void doTrans(JoinPoint jp,Object res){ //JoinPoint 不能放res后面
        //System.out.println(res);
        System.out.println("后置方法：提交事务....");
    }

    @AfterReturning(value = "execution(public * testSys(..))",returning = "res")
    public static void testSys(Object res){

        System.out.println(res);
        SysUser user = (SysUser)res;
        user.setName("张三");
        System.out.println("后置方法：提交事务....");
    }

    @Around(value = "execution(public * testAround(..))")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("执行前通知");

        Object res = pjp.proceed();//等同于 method.invoke();

        System.out.println("执行后通知");

        res = "hahhahah";

        return res;
    }

    @AfterThrowing(value = "execution(public * testAfterThrowing(..))" , throwing = "ex")
    public void myAfterThrowing(Exception ex){

        System.out.println(ex.getMessage());
        System.out.println("发生异常，立即发送邮件给程序猿");
    }

    @After(value = "mypt()")
    public void myAfter(){

        System.out.println("不管怎么都会执行的After注解！！！！");
    }

    // 定义切入点（辅助功能） 统一管理
    @Pointcut(value = "execution(public * test*(..))")
    public void mypt(){

    }
}
