package com.baizhi.service;

import com.baizhi.entity.Admina;
import com.baizhi.entity.Users;

import java.util.List;

public interface UsersService {
    //查询所有
    public List<Users> selectShowAll();
    //删除
    public void modifydeleteShowAll(Integer id);
    //查询id
    public Users selectById(Integer id);
    //修改
    public void modifyupdateShowAll(Users users);
    //添加
    public void modifyinsertShowAll(Users users);
}
