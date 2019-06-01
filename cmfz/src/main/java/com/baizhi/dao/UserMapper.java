package com.baizhi.dao;


import com.baizhi.entity.EchartsMap;
import com.baizhi.entity.EchartsMap1;
import com.baizhi.entity.EchartsMap2;
import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String[] id);
    //添加
    int insert(User record);

    int insertSelective(User record);
    //查询
    User selectByPrimary(String id);
    //上传修改
    int updateByPrimaryKeySelective(User record);
    //修改
    int updateByPrimaryKey(User record);
//查询所有

    List<User>getAll();
    //分页
    List<User> selectByPrimaryKey(@Param("start") Integer start, @Param("rows") Integer rows);
    Integer getRecords();
    //一周用户走势图
    List<EchartsMap> goeasy();
    //驰名法州用户分布图
    List<EchartsMap1> cmfz();
    //月份走势图
    List<EchartsMap2> goeasy2();
}