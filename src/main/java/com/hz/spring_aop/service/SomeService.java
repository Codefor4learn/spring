package com.hz.spring_aop.service;


import com.hz.spring_aop.domain.SysUser;

public interface SomeService {

    public void doSome(String name,Integer age);

    public String doOthers();

    public SysUser testSys();

    public String testAround();

    public void testAfterThrowing();
}
