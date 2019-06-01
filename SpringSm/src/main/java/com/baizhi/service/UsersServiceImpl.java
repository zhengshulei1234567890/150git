package com.baizhi.service;


import com.baizhi.dao.UsersDao;
import com.baizhi.entity.Users;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao;

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    //查询所有
    @Override
    public List<Users> selectShowAll() {
        List<Users> users = usersDao.selectAll();
        return users;
    }

    @Override
    public void modifydeleteShowAll(Integer id) {
        usersDao.deleteAll(id);
    }

    @Override
    public Users selectById(Integer id) {
        Users users = usersDao.selectById(id);
        return users;
    }

    @Override
    public void modifyupdateShowAll(Users users) {
        usersDao.updateAll(users);
    }

    @Override
    public void modifyinsertShowAll(Users users) {
        usersDao.insertAll(users);
    }
}
