package com.baizhi.service;

import com.baizhi.dao.AdminaDao;
import com.baizhi.entity.Admina;

public class AdminaServiceImpl implements AdminaService {
    private AdminaDao adminaDao;

    public AdminaDao getAdminaDao() {
        return adminaDao;
    }

    public void setAdminaDao(AdminaDao adminaDao) {
        this.adminaDao = adminaDao;
    }



    // 登录
    @Override
    public Admina loginNamePass(String username, String password) {
        Admina admina = adminaDao.loginUsers(username, password);
        return admina;
    }
    //注册
    @Override
    public void modifyRegistAll(Admina admina) {
        adminaDao.registerAll(admina);

    }

}
