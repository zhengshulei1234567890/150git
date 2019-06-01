package com.baizhi.staticproxy;
//房东 原始类
public class LandloadServiceImpl implements LandlordService{
    //出租房屋 原始方法
    @Override
    public void land() {
        //核心功能
        System.out.println("签合同");
        System.out.println("收钱");
    }
}
