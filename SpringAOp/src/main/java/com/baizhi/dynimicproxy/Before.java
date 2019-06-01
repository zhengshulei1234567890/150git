package com.baizhi.dynimicproxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before implements MethodBeforeAdvice {
    /*
     * 作用：书写运行在原始方法之前执行的额外功能
     * 参加的含义：method 代表添加给的原始方法对象
     *              org   代表添加给的原始方法的实参
     *              targer 代表添加给的方法原始对象
     * */
    @Override
    //额外功能类
    public void before(Method method, Object[] args, Object targer) throws Throwable {
        //添加额外功能
      /*  System.out.println("--------事物控制666666----------");
        //输出原始方法的方法名
        String name = method.getName();
        System.out.println(name);
        //输出原始方法的实参
        for (Object arg : args) {
            System.out.println(arg);
        }
        //输出原始对象的类型
        System.out.println(targer.getClass());*/
    }
}
