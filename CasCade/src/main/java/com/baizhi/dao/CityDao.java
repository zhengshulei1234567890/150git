package com.baizhi.dao;

import com.baizhi.entity.City;

import java.util.List;

public interface CityDao {
    //通过省的code 获取对应的市
    public List<City> selectCityprovincecode(String provincecode);
}
