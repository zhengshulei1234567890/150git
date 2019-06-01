package com.baizhi.staticproxy;

import org.junit.Test;

public class TestLandLord {

    @Test
    public void testLandLoad(){
        //中介
        LandlordService is=new LandServiceProxyServiceImpl();
        is.land();
    }
}
