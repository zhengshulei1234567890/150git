package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserDao userDao;
    //展示所有
    @Override
    public List<User> queryAll() {
        List<User> users = userDao.queryAll();
        return users;
    }

    @Override
    public User showAll(String username, String password) {
        User user = userDao.showAll(username, password);
        return user;
    }

    @Override
    public void registerUser(User user) {
        userDao.registerShowAll(user);
    }
}
