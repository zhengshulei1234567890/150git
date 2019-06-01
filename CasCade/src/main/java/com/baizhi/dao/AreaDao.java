package com.baizhi.dao;

import com.baizhi.entity.Area;

import java.util.List;

public interface AreaDao {
    public List<Area> selectArea(String citycode);
}
