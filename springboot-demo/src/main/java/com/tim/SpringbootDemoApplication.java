package com.tim;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);
        DruidDataSource dataSource = (DruidDataSource)context.getBean("primaryDataSource");
        dataSource.setPassword(dataSource.getPassword()+ "t");
        System.out.println(dataSource);

    }

}
