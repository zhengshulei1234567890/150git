package com.baizhi.service;

import com.baizhi.entity.Admin;

import java.util.List;

public interface AdminService {
    //查询所有
    public List<Admin> queryShowAll();
    //管理员登录
    public Admin loginShowAll(String username,String password);
    //注册
    public void  save(Admin admin);
    //查询id
    public Admin selectId(Integer id);
    //修改
    public void update(Admin admin);
}
