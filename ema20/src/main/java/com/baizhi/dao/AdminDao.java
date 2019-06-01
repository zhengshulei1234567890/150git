package com.baizhi.dao;

import com.baizhi.entity.Admin;
import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface AdminDao {
    //展示所有
    public List<Admin> queryShowAll();
    //管理员登录
    public Admin loginShowAll(@Param("username") String username, @Param("password") String password);
    //添加
    public void save(Admin admin);
    //修改
    public void update(Admin admin);
    //回显
    public Admin selectShow(Integer id);

    //分页
    public List<Admin> selectfidsid(@Param("fid") String fid, @Param("sid") String sid, @Param(value = "begin") int begin, @Param(value = "end") int end);
    public Integer totalCount(@Param("fid") String fid, @Param("sid") String sid);
}
