package com.baizhi.service;

import com.baizhi.entity.Banner;
import com.baizhi.entity.EchartsMap1;
import com.baizhi.entity.EchartsMap2;
import com.baizhi.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {
    //分页
    Map<String,Object> selectByPrimaryKey(Integer page, Integer rows);
    //添加
    public String  insert(User user);
    //上传
    public void upload(MultipartFile headPic, HttpSession session, String userId);
    //修改
    public String update(User user);
    //删除数组
    public void deleteByid(String[] id);
    //查询所有
    List<User>getAll();
    //一周注册走势图
    Map<String,Object> goeasy();
    //驰名法州用户分布图
    List<EchartsMap1> cmfz();
    //月份
    Map<String,Object> goeasy2();
}
