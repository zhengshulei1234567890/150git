package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> queryAll() {
        List<User> list = userDao.queryAll();
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User queryUserByNameAndpassword(String name,String password) {
        User user = userDao.queryUserByNameAndPass(name,password);
        return user;
    }

    @Override
    public void deleteByName(String name) {
        userDao.deleteByName(name);
    }

    @Override
    public void addUser(User user) {
        user.setSource("微信");
        user.setIp("192.168.0.1");
        String status = user.getStatus();
        if("No".equals(status)){
            user.setStatus("冻结");
        }else {
            user.setStatus("正常");
        }
        userDao.addUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> findByNameLike(String username) {
        List<User> users = userDao.queryUserLike(username);
        return users;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User findByName(String username) {
        User user = userDao.queryByName(username);
        return user;
    }

    @Override
    public void updateStatus(User user) {
        userDao.update(user);
    }

    @Override
    public void register(User user) {
        userDao.register(user);
    }

    @Override
    public List<User> findUserByPage(Integer count) {
        List<User> list = userDao.queryAllNyPage(count);
        return list;
    }
}
