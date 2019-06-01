package com.baizhi.serviceImpl;

import java.util.List;
import java.util.UUID;

import com.baizhi.dao.UserDao;
import com.baizhi.Service.UserService;
import com.baizhi.util.MybatisUtil;
import com.baizhi.util.SecurityCode;
import com.baizhi.entity.User;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;


public class UserServiceImpl implements UserService {

    @Override
    public List<User> queryAllUser() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapperDao = sqlSession.getMapper(UserDao.class);
        //UserDao mapperDao = (UserDao) MybatisUtil.getMapper(UserDao.class);
        List<User> list = mapperDao.queryAllUser();
        MybatisUtil.close();
        return list;
    }

    //查询
    @Override
    public User useremail(String email) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapperDao = sqlSession.getMapper(UserDao.class);
        //UserDao mapperDao = (UserDao) MybatisUtil.getMapper(UserDao.class);
        User useremailDao = mapperDao.useremail(email);
        return useremailDao;
    }

    //修改
    @Override
    public void update(User user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapperDao = sqlSession.getMapper(UserDao.class);
        //UserDao mapperDao = (UserDao) MybatisUtil.getMapper(UserDao.class);
        mapperDao.update(user);
        MybatisUtil.commit();
        MybatisUtil.close();
    }


    //front

    //前台登录
    @Override
    public User selectAll(String email, String password) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao mapperDao = sqlSession.getMapper(UserDao.class);
      //  UserDao mapperDao = (UserDao) MybatisUtil.getMapper(UserDao.class);
        User user = mapperDao.useremail(email);
        if (user == null) {
            throw new RuntimeException("邮箱不存在");
        }
        String salt = user.getSalt();
        //	铭文=	密码+ 盐
        password = password + salt;
        //	密文    =	md5加密(password)
        password = DigestUtils.md5Hex(password);

        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        if (user.getStatus().equals("冻结")) {
            throw new RuntimeException("用户被冻结");
        }

        return user;
    }


    //注册
    @Override
    public User insertUser(User user) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao ud = sqlSession.getMapper(UserDao.class);
        //UserDao ud = (UserDao) MybatisUtil.getMapper(UserDao.class);
        String id = UUID.randomUUID().toString();
        user.setId(id);

        String code = SecurityCode.getSecurityCode();
        String password = user.getPassword() + code;//盐
        password = DigestUtils.md5Hex(password);
        user.setPassword(password);
        user.setSalt(code);
        user.setStatus("冻结");
        //user.setCode("dfds");

        ud.insertUser(user);
        ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
        MybatisUtil.commit();
        MybatisUtil.close();

        return user;
    }

    @Override
    public void update1(User user, String code) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserDao ud = sqlSession.getMapper(UserDao.class);
        //UserDao ud = (UserDao) MybatisUtil.getMapper(UserDao.class);
        String code1 = (String) ServletActionContext.getRequest().getSession().getAttribute("emailcode");
        if (!code1.equals(code)) {
            throw new RuntimeException("邮箱格式不正确");
        }
        user.setCode(code);
        user.setStatus("正常");
        ud.update1(user);
        MybatisUtil.commit();
        MybatisUtil.close();
    }


}
