package com.baizhi.service;


import com.baizhi.dao.UserMapper;
import com.baizhi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.*;

@Service
@Transactional
public class UserServiceimpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, Object> selectByPrimaryKey(Integer page, Integer rows) {
        Map<String, Object> map = new HashMap<>();
        Integer start = (page - 1) * rows;
        List<User> articles = userMapper.selectByPrimaryKey(start, rows);
        Integer records = userMapper.getRecords();
        int total = records % rows == 0 ? records/rows : records / rows + 1;
        map.put("page", page);
        map.put("records", records);
        map.put("total", total);
        map.put("rows", articles);
        return map;
    }
    //添加
    @Override
    public String insert(User user) {
        String id = UUID.randomUUID().toString().replace("-", "");
        user.setId(id);
        user.setCreateDate(new Date());
        userMapper.insert(user);
        return user.getId();
    }
    //上传修改
    @Override
    public void upload(MultipartFile headPic, HttpSession session, String userId) {
        //判断上传文件夹是否存在
        String realPath = session.getServletContext().getRealPath("/img");
        File file = new File(realPath);
        if (!file.exists()){
            file.mkdirs();
        }
        String originalFilename = headPic.getOriginalFilename();
        String str = new Date().getTime() + "_" + originalFilename;
        try {
            headPic.transferTo(new File(realPath,str));
            User user = new User();
            user.setId(userId);
            user.setHeadPic(str);
            userMapper.updateByPrimaryKeySelective(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //修改
    @Override
    public String update(User user) {
        if (user.getHeadPic().equals("") || user.getHeadPic()==null){
            User user1 = userMapper.selectByPrimary(user.getId());
            user.setHeadPic(user1.getHeadPic());
            userMapper.updateByPrimaryKey(user);
        }else{
            userMapper.updateByPrimaryKey(user);
        }
        return user.getId();
    }
    //删除
    @Override
    public void deleteByid(String[] id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> getAll() {
        List<User> list = userMapper.getAll();
        return  list;
    }

    @Override
    public Map<String, Object> goeasy() {
        Map<String, Object> map = new HashMap<>();
        List<Object> list = new ArrayList<>();
        List<Object> list1 = new ArrayList<>();
        List<EchartsMap> goeasy = userMapper.goeasy();
        for (EchartsMap echartsMap : goeasy) {
            Date time = echartsMap.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = simpleDateFormat.format(time);
            String count = echartsMap.getCount();
            list.add(date);
            list1.add(count);
        }
        map.put("日期",list);
        map.put("数量",list1);
        return map;
    }

    @Override
    public List<EchartsMap1> cmfz() {
        List<EchartsMap1> list = userMapper.cmfz();
        return list;
    }

    @Override
    public Map<String, Object> goeasy2() {
        Map<String, Object> map = new HashMap<>();
        List<EchartsMap2> list = userMapper.goeasy2();
        List<Integer> list1 = new ArrayList<>();
        List<String> list2=new ArrayList<>();
        for (EchartsMap2 map2 : list) {
            Integer count = map2.getCount();
            list1.add(count);
            Integer month = map2.getMonth();
            list2.add(month+"月");

            map.put("list2",list2);
            map.put("list1",list1);
        }

        return map;
    }


}