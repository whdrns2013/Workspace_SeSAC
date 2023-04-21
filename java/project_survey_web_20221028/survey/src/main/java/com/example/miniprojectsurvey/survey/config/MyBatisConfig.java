package com.example.miniprojectsurvey.survey.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.example.miniprojectsurvey.survey.mapper")
public class MyBatisConfig {
    
}
