package com.baizhi.test;

import com.baizhi.Service.AreaService;
import com.baizhi.Service.AreaServiceImpl;
import com.baizhi.Service.CityService;
import com.baizhi.Service.CityServiceImpl;
import com.baizhi.dao.AreaDao;
import com.baizhi.dao.CityDao;
import com.baizhi.dao.ProvinceDao;
import com.baizhi.entity.Area;
import com.baizhi.entity.City;
import com.baizhi.entity.Province;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.List;

public class TestProvince {
    @Test
    public void test1() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProvinceDao mapper = sqlSession.getMapper(ProvinceDao.class);
        List<Province> provinces = mapper.selectAllProvince();
        for (Province province : provinces) {
            System.out.println(province);
        }
    }

    @Test
    public void test2() {
       /* SqlSession sqlSession = MybatisUtil.getSqlSession();
        CityDao cityDao = sqlSession.getMapper(CityDao.class);*/
        /*  List<City> cities = cityDao.selectCityprovincecode("130000");*/
        CityService cs = new CityServiceImpl();
        List<City> citys = cs.showCity("120000");
        for (City city : citys) {
            System.out.println(city);
        }
    }

    @Test
    public void test3() {
        //SqlSession sqlSession = MybatisUtil.getSqlSession();
        //AreaDao areaDao = sqlSession.getMapper(AreaDao.class);
       // List<Area> areas = areaDao.selectArea("110100");
        AreaService as= new AreaServiceImpl();
        List<Area> areas = as.showArea("110100");
        for (Area area : areas) {
            System.out.println(area);
        }
    }
}