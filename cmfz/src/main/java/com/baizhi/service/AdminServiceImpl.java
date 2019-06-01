package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminServiceImpl implements  AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Map<String, String> adminLogin(String username, String password, String enCode, HttpSession session) {
        String code = (String) session.getAttribute("enCode");

        Map<String, String> map = new HashMap<String, String>();

        //验证码
        if (enCode.equals(code)) {
            Admin admin = adminDao.queryAll(username);

            if (admin != null){

                if (admin.getPassword().equals(password)){
                   map.put("msg","Ok");
                }else {
                    map.put("msg","密码错误");
                }
            }else{
                map.put("msg","账号错误");
            }
        } else {
            map.put("msg", "验证码错误");
        }
        return map;
    }
}












       /* String message = null;

       if(!password.equals(admin.getPassword())){
            message="账号或密码错误";
        }else if(!enCode.equals(code)){
            message="验证码错误";
        }else {
            session.setAttribute("admin",admin);
        }
        map.put("message",message);
        return map;
    }*/



