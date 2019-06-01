package com.baizhi.Service;

import com.baizhi.dao.CityDao;
import com.baizhi.entity.City;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CityServiceImpl implements CityService{
    @Override
    public List<City> showCity(String provincecode) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        CityDao cityDao = sqlSession.getMapper(CityDao.class);
        List<City> citys = cityDao.selectCityprovincecode(provincecode);
        MybatisUtil.close();
        return citys;
    }


}
