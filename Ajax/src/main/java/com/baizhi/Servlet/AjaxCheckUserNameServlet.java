package com.baizhi.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxCheckUserNameServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           Thread.sleep(5000);
       }  catch (InterruptedException e){
           e.printStackTrace();
       }

        //接收数据
        String username = req.getParameter("username");
        //解决响应乱码问题
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        if("小黑".equals(username)){
            out.print("您的用户重复，请更换");
        }else{
            out.print("正确");
        }
    }
}
