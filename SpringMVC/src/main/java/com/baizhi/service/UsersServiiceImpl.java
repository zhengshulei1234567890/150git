package com.baizhi.service;

import com.baizhi.dao.UsersDao;
import com.baizhi.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersServiiceImpl implements  UsersService{
    @Autowired
    private UsersDao usersDao;
    @Override
    public void register(Users users) {
        usersDao.save(users);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Users> showAll() {
        List<Users> users = usersDao.selectAll();
        return users;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Users login(String name, String password) {
        Users users = usersDao.loginusernameandpassword(name, password);

        return users;
    }
}
