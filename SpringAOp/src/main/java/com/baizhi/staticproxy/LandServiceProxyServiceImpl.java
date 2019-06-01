package com.baizhi.staticproxy;
//代理 中介    代理类
public class LandServiceProxyServiceImpl implements LandlordService{
   //出租房屋
    @Override
    public void land() {
        //额外功能
        System.out.println("贴广告");
        System.out.println("带客户看房");
        //请用房东出租房屋的方法
        LandloadServiceImpl landloadService=new LandloadServiceImpl();
        landloadService.land();
    }
}
