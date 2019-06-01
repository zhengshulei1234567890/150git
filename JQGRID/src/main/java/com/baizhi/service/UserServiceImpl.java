package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public Map<String, Object> show(Integer page, Integer rows) {
        HashMap<String, Object> map = new HashMap<>();
       //当前页数
        map.put("page",page);

        Integer totalcount = userDao.selectAll();
        //总条数
        map.put("records",totalcount);
       Integer pageCount=0;
        //总页数
        if(totalcount%rows!=0){
            pageCount=totalcount/rows+1;
        }else {
            pageCount=totalcount/rows;
        }
        map.put("total",pageCount);
        //当前数据内容
        List<User> user = userDao.showAll(page, rows);
        map.put("rows",user);
        return map;
    }
}
