package com.hz.spring_aop;

import org.springframework.stereotype.Component;

@Component("testProxy")
public class TestProxyService {

    public void doSome(){
        System.out.println("测试生成类");
    }
}
