package com.baizhi.dynimicproxy;

public class UserServiceImpl implements UserService{
    @Override
    public void register() {
        //核心功能
        System.out.println("调用插入的DAO");
    }

    @Override
    public int register(String name) {
        System.out.println("我是带有一个参数的插入方法");
        throw new RuntimeException();
       // return 999;
    }

    @Override
    public void register(String name, String password) {
        System.out.println("我是带有两个参数的方法");
    }

    @Override
    public void update() {

            System.out.println("调用更新的DAO");
    }
}
