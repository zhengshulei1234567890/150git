package com.baizhi.dynimicproxy;

import org.springframework.aop.ThrowsAdvice;

public class Throws implements ThrowsAdvice {
    //实现方法       严格遵从实现规范
    public void afterThrowing(Exception e){
        System.out.println("我是产生异常的额外功能");
    }
}
