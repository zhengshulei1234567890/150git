package com.baizhi.Service;

import com.baizhi.dao.ProvinceDao;
import com.baizhi.entity.Province;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;


import java.util.List;

public class ProvinceServiceImpl implements  ProvinceService{
    @Override
    public List<Province> showAllProvince() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        ProvinceDao provinceDao = sqlSession.getMapper(ProvinceDao.class);
        List<Province> provinces = provinceDao.selectAllProvince();
        MybatisUtil.close();
        return provinces;
    }
}
