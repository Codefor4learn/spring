package com.hz.spring_ioc.service.Impl;

import com.hz.spring_ioc.service.SomeService;

public class SomeServiceImpl implements SomeService {

    public SomeServiceImpl(){
        //System.out.println("执行构造方法");
    }

    public void doSome() {
        System.out.println("doSome.....");
    }
}
