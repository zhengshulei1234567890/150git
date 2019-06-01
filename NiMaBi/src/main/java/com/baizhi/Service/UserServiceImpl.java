package com.baizhi.Service;

import com.baizhi.Dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService{
    @Override
    public void register(User user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.save(user);
//          提交事物
            MybatisUtil.commit();
        }catch(Exception e){
            e.printStackTrace();
//            回滚
            MybatisUtil.rollback();
        }

    }

    @Override
    public User showAll(String username) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectAll(username);
        return user;
    }
}
