package com.baizhi.Service;

import com.baizhi.entity.User;

import java.util.List;

public interface UserService {
    //注册
    public void modifyregister(User user);
    //修改
    public void modifyupdate(User user);
    //查询
    public List<User> modifyselectAll();
    //删除
    public void modifydelete(Integer id);
    //批量删除
    public void modifydeleteById(Integer[] ids);
}
