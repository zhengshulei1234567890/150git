package com.baizhi.FactoryBean;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.FactoryBean;

import javax.annotation.Resource;
import java.io.InputStream;

public class MySqlSessionFactory implements FactoryBean<SqlSessionFactory> {
    //书写创建sqlsessionFactory的步骤
    @Override
    public SqlSessionFactory getObject() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        return sqlSessionFactory;
    }
//返回复杂对象的类型
    @Override
    public Class<?> getObjectType() {
        return SqlSessionFactory.class;
    }
//创建复杂的对象的次数
    @Override
    public boolean isSingleton() {
        return true;
    }
}
