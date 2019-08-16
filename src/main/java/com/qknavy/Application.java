package com.qknavy;

import com.qknavy.datasources.druid.DynamicDataSource.EnableDynamicDatasource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.qknavy.*.mapper")
@EnableDynamicDatasource
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}