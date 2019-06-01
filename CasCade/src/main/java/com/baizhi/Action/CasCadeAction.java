package com.baizhi.Action;

import com.alibaba.fastjson.JSON;
import com.baizhi.Service.*;
import com.baizhi.entity.Area;
import com.baizhi.entity.City;
import com.baizhi.entity.Province;
import org.apache.struts2.ServletActionContext;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;



public class CasCadeAction {
    private String provincecode;
    private String citycode;

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getProvincecode() {
        return provincecode;
    }

    public void setProvincecode(String provincecode) {
        this.provincecode = provincecode;
    }

    public String showAllProvince(){
        //调用业务
        ProvinceService ps=new ProvinceServiceImpl();
        List<Province> provinces = ps.showAllProvince();
        //转json协议串
        String jsonString = JSON.toJSONString(provinces);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            out.print(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
//通过省份的code  获取对应的市
    public String showcity(){
        CityService cs=new CityServiceImpl();
        List<City> citys = cs.showCity(provincecode);


        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try {
            //转json协议串
            String jsonString = JSON.toJSONString(citys);
            PrintWriter out = response.getWriter();
            out.print(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public String areashow(){
        AreaService as=new AreaServiceImpl();
        List<Area> areas = as.showArea(citycode);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        try {
            String jsonString = JSON.toJSONString(areas);
            PrintWriter out = response.getWriter();
            out.print(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
