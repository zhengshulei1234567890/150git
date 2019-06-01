package com.baizhi;

import com.baizhi.dao.*;
import com.baizhi.entity.*;
import com.baizhi.service.*;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.assertj.core.util.Maps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.util.Password;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        Map<String, Object> map = userService.goeasy2();
        System.out.println(map);
    }
}
