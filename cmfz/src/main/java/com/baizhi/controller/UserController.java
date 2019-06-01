package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.EchartsMap1;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("getUserByPager")
    public Map<String,Object> getUserByPager(Integer page, Integer rows){
        Map<String, Object> map = userService.selectByPrimaryKey(page, rows);
        return map;
    }
    //添加
    @RequestMapping("/edit")
    public Map<String, String> insert(User user, String oper, String[] id) {
        HashMap<String, String> map = new HashMap<>();
        if (oper.equals("add")) {
            String s = userService.insert(user);
            map.put("msg", "添加成功");
            map.put("userId", s);
        }else if (oper.equals("edit")){
            String headPic = user.getHeadPic();
            if (headPic.equals("")){
                map.put("userId","");
                map.put("msg","修改成功");
                userService.update(user);
            }else {
                map.put("userId",user.getId());
                map.put("msg","修改成功");
                userService.update(user);
            }

        }else if (oper.equals("del")){
            userService.deleteByid(id);
            map.put("msg","删除信息");
        }
        return map;
    }
    //上传
    @RequestMapping("/upload")
    public void upload(MultipartFile headPic, HttpSession session, String userId) {
        userService.upload(headPic, session, userId);
    }
    //EasyPoi
    @RequestMapping("easyPoiOut")
    public void easyPoiOut(HttpSession session, HttpServletResponse response) throws Exception {
        String realPath = session.getServletContext().getRealPath("/img/");
        List<User> list = userService.getAll();
        for (User user : list) {
            user.setHeadPic(realPath+user.getHeadPic());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("150班学生","学生信息表"),
                User.class, list);

        ServletOutputStream outputStream=null;

        try {
            outputStream=response.getOutputStream();
            String encode = URLEncoder.encode("E:/xuesheng.xls", "utf-8");
            response.setHeader("content-disposition","attachment;filename="+encode);
            workbook.write(outputStream);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            outputStream.close();
        }
    }
    //一周注册走势图
    @RequestMapping("/goeasy")
    public List<Object> goeasy(){
        ArrayList<Object> list = new ArrayList<>();
        Map<String, Object> goeasy = userService.goeasy();
        list.add(goeasy);
        return list;
    }
    //驰名法州分布图
    @RequestMapping("/goeasy1")
    public List<EchartsMap1> goeasy1(){
        List<EchartsMap1> cmfz = userService.cmfz();
        return cmfz;
    }
    //月份
    @RequestMapping("/goeasy2")
    public Map<String,Object> goeasy2(){

        Map<String, Object> goeasy = userService.goeasy2();

        return goeasy;
    }
}
