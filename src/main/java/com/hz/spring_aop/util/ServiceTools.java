package com.hz.spring_aop.util;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Date;

public class ServiceTools {

    public static void doLog(){

        System.out.println("目标方法执行时间：" + new Date());
    }

    public static void doTrans(){

        System.out.println("提交事务....");
    }
}
