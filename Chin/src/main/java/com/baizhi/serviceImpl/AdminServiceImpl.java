package com.baizhi.serviceImpl;

import java.util.List;


import com.baizhi.dao.AdminDao;
import com.baizhi.Service.AdminService;
import com.baizhi.util.MybatisUtil;
import com.baizhi.entity.Admin;
import org.apache.ibatis.session.SqlSession;

public class AdminServiceImpl implements AdminService {

	@Override
	public List<Admin> findAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminDao ad = sqlSession.getMapper(AdminDao.class);
        //AdminDao ad= (AdminDao) MybatisUtil.getMapper(AdminDao.class);
		List<Admin> list=ad.findAll();
		return list;
	}

	@Override
	public Admin findLogin(String username, String password) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        AdminDao ad = sqlSession.getMapper(AdminDao.class);
	    //AdminDao ad= (AdminDao)MybatisUtil.getMapper(AdminDao.class);
		Admin findLogin = ad.findLogin(username, password);
		
		return findLogin;
	}
	

}
