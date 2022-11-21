package com.example.sessac.first.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.example.sessac.first.mapper")
public class MyBatisConfig {
    
}


