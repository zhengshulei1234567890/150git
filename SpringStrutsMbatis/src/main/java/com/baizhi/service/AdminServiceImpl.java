package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
   @Autowired
    private AdminDao adminDao;

    /*public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
    */
    //登录
    @Override
    @Transactional( propagation = Propagation.SUPPORTS, readOnly = true)
    public Admin loginShowAll(String username, String password) {
        Admin admin = adminDao.loginAll(username, password);
        return admin;
    }
    //注册
    @Override
    public void modifyregisterShowAll(Admin admin) {
        adminDao.registerAll(admin);
    }
}
