package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
/*@ComponentScan(basePackages = "com.baizhi.*")
@Configuration
@EnableAutoConfiguration*/
@MapperScan(basePackages = "com.baizhi.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
//项目名   Plugins    spring-boot   spring-boot:run
}
