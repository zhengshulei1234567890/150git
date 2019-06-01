package com.baizhi.FactoryBean;

import org.hamcrest.Factory;
import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

public class Myconnection implements FactoryBean<Connection> {
   //书写 创建复杂对象的步骤
    @Override
    public Connection getObject() throws Exception {
        //创建connection对象
        Class.forName("oracle.jdbc.OracleDriver");
        Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

        return connection;
    }
//返回创建的复杂对象的类型
    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }
//控制复杂对象的创建次数  根据创建复杂对象的特点 设置返回值 连接对象返回false 每已创建一个 比较安全
    @Override
    public boolean isSingleton() {
        /*
        * false:不单例  每次都会创建新的对象
        * true: 单例    应用只会创建一个对象
        * */
        return false;
    }
}
