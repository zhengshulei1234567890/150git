package com.baizhi.service;

import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private static Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

   @Autowired
    UserMapper userMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryAll() {
        List<User> users=userMapper.queryAll();
        return users;
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }
}
