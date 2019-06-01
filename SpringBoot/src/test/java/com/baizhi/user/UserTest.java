package com.baizhi.user;

import com.baizhi.App;
import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import javafx.scene.shape.VLineTo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = App.class)//声明是springboot的测试类 并且指定入口类
@RunWith(SpringRunner.class)  //在工厂环境下启动测试
public class UserTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void  testUser(){
        List<User> users = userMapper.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
        @Test
    public void test3(){
        userMapper.save(new User(7,"xj","123123"));
        }
}
