package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@ComponentScan(basePackages = "com.baizhi.*")
@Configuration
@EnableAutoConfiguration*/
@MapperScan(basePackages = "com.baizhi.dao")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
//项目名   Plugins    spring-boot   spring-boot:run
}
