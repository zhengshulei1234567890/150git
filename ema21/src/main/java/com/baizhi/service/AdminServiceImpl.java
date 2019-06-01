package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl  implements AdminService{
    @Autowired
    private AdminDao adminDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Admin login(String name, String password) {
        Admin admin = adminDao.findAdminByNameAndPwd(name, password);
        return admin;
    }
}
