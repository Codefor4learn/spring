package com.hz.spring_aop;

import com.hz.spring_aop.util.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {


    private Object target;

    public MyInvocationHandler() {
    }

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 通过代理对象执行方法时候，会调用执行这个invoke方法

        Object res = null;

        ServiceTools.doLog();
        // 执行目标类方法，通过method类实现
        res = method.invoke(target,args); //实现SomeServiceImpl.doOthers() doSome()方法
        ServiceTools.doTrans();

        //目标方法执行结果
        return res;
    }
}
