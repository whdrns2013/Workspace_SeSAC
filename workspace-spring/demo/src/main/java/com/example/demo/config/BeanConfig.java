package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



@Configuration
public class BeanConfig {
    
    @Bean
    public String bean1(){
        return "첫 번째 bean";
    }
    // -> bean1이라는 메서드를 Bean 객체로 등록시키겠다
    // -> bean1메서드는 "첫 번째 bean"이라는 String 값을 반환한다.
    
    // com.example.demo.config 디렉토리 안에 component 들을 스캔한다는 뜻.
    // basePackages : 검색을 할 패키지를 지정
    @Configuration
    @ComponentScan ( basePackages = "com.example.demo.config")
    public class BeanConfiguration {
    }


}
