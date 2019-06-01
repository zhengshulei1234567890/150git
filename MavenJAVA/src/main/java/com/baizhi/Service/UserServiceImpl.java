package com.baizhi.Service;

import com.baizhi.dao.UserDao;

public class UserServiceImpl implements UserService{
   private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register() {
        //创建dao实现类对象
        //  调用Dao

        userDao.save();
    }
}
