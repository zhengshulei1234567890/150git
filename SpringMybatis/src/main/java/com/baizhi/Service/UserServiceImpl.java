package com.baizhi.Service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;

import java.util.List;

//原始类
public class UserServiceImpl implements UserService{
   //通过set注入给userDao注入实现类对象
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
//核心功能
    @Override
    public void modifyregister(User user) {
        //调用dao
        userDao.register(user);
    }

    @Override
    public void modifyupdate(User user) {
        //调用dao
        userDao.update(user);
    }

    @Override
    public List<User> modifyselectAll() {
        List<User> users = userDao.selectAll();

        return users;
    }

    @Override
    public void modifydelete(Integer id) {
        userDao.delete(id);

    }

    @Override
    public void modifydeleteById(Integer[] ids) {
        userDao.deleteById(ids);
    }

}
