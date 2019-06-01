package com.baizhi.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

public class CheckUserNameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      try {
          Thread.sleep(5000);
      }catch (InterruptedException e){
          e.printStackTrace();
      }

        //接受用户名
        String username = req.getParameter("username");
        //校验用户名
        if("小黑".equals(username)){
            //提示信息
            req.setAttribute("message","您的用户已经重复，请更换");

        }else{
            req.setAttribute("message","您的用户名 合理");
        }
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
    }
}
