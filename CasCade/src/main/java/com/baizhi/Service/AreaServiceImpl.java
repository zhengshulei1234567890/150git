package com.baizhi.Service;

import com.baizhi.dao.AreaDao;
import com.baizhi.entity.Area;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AreaServiceImpl  implements  AreaService{
    @Override
    public List<Area> showArea(String citycode) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AreaDao areaDao = sqlSession.getMapper(AreaDao.class);
        List<Area> areas = areaDao.selectArea(citycode);
        return areas;
    }
}
