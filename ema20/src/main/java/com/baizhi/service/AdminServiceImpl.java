package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl  implements AdminService{
   @Autowired
   private AdminDao adminDao;
    //查询所有
    @Override
    public List<Admin> queryShowAll() {
        List<Admin> admins = adminDao.queryShowAll();
        return admins;
    }
    //登录
    @Override
    public Admin loginShowAll(String username, String passwrod) {
        Admin admin = adminDao.loginShowAll(username, passwrod);
        return admin;
    }
    //注册
    @Override
    public void save(Admin admin) {
        adminDao.save(admin);
    }


    //查询id
    @Override
    public Admin selectId(Integer id) {
        Admin admin = adminDao.selectShow(id);
        return admin;
    }
    //修改
    @Override
    public void update(Admin admin) {
        adminDao.update(admin);
    }

}
