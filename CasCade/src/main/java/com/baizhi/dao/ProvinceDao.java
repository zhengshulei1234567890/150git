package com.baizhi.dao;

import com.baizhi.entity.Province;

import java.util.List;

public interface ProvinceDao {
    //查询所有的省份
    public List<Province> selectAllProvince();
}
