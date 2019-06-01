package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;
    @Override
    @Transactional( propagation = Propagation.SUPPORTS, readOnly = true)
    public Admin login(String username, String password) {
        Admin admin = adminDAO.selectByUserName(username, password);
        return admin;
    }

    @Override
    public void regist(Admin admin) {
        adminDAO.save(admin);
    }
}
