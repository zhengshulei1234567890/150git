package com.baizhi.dynimicproxy;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class After implements AfterReturningAdvice {
    /*
    * 方法作用：额外功能运行在原始方法执行之后执行
    * 参数作用：ret:代表添加给的原始方法的返回值
    *           method:代表添加给的原始方法的对象
    *           args  :代表添加给的原始方法对应的实际参数
    *           target:代表添加给的原始方法所在的原始创建的对象
    * */
    @Override
    public void afterReturning(Object ret, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("--------我是额外功能----------");
        //输出原始方法的返回值
        System.out.println(ret);
        //输出原始方法的对象
        System.out.println(method.getName());
        //输出原始方法的实际参数
        for (Object arg : args) {
            System.out.println(arg);
        }
        //原始方法所在的原始创建的对象
        System.out.println(target.getClass());
    }
}
