package com.baizhi.dynimicproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//MethodInterceptor接口 运行在原始方法之前后执行 环绕通知
public class Arount implements MethodInterceptor {
    /*
    * 方法的作用：额外功能运行在原始方法之前后执行
    * 参数的作用：mi  代表添加的原始方法对应的对象的封装
    *            Object:代表 原始方法执行过后的返回值
    * */

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("我是在原始方法之前执行的额外功能");
        //执行原始方法
        Object proceed = mi.proceed();
        System.out.println("我是原始方法之后执行的额外功能");
        System.out.println(proceed);
        return proceed;
    }
}
