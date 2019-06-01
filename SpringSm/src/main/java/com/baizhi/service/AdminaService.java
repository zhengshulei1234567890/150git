package com.baizhi.service;

import com.baizhi.entity.Admina;

import java.util.List;

public interface AdminaService {

    //登录
    public Admina loginNamePass(String username,String password);
    //注册
    public void modifyRegistAll(Admina admina);
    //
}
