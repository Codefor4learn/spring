package com.hz.spring_aop.service.Impl;

import com.hz.spring_aop.domain.SysUser;
import com.hz.spring_aop.service.SomeService;
import org.springframework.stereotype.Service;

@Service("someService")
public class SomeServiceImpl implements SomeService {

    @Override
    public void doSome(String name,Integer age) {
        System.out.println("执行doSome方法");
    }

    @Override
    public String doOthers() {
        System.out.println("执行doOther方法");
        return "我是方法执行结果，可以被后置方法调用";
    }

    @Override
    public SysUser testSys(){

        System.out.println("执行testSys方法");
        SysUser user = new SysUser();
        user.setName("黄震");
        user.setAge(21);
        return user;
    }

    @Override
    public String testAround(){

        System.out.println("执行testAround方法");
        return "abc";
    }

    @Override
    public void testAfterThrowing() {
        int i = 0/0;
    }
}
