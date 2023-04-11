package com.lingjie.oasystem;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@MapperScan("com.lingjie.oasystem.dao")
//@EnableAspectJAutoProxy
@EnableTransactionManagement
public class OasystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OasystemApplication.class, args);
    }

}
