package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.config.Bean3;
import com.example.demo.config.BeanConfig;
import com.example.demo.config.ImageUtil;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		// ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		// String s = (String) context.getBean("bean1");
		// System.out.println("bean 생성1 : " + s);
		
		// ApplicationContext context2 = new ClassPathXmlApplicationContext("classpath:bean2.xml");
		// int i = (int) context2.getBean("bean2");
		// System.out.println("bean 생성2 : " + i);

		// ApplicationContext context3 = new AnnotationConfigApplicationContext(BeanConfig.class);
		// Bean3 b = (Bean3) context3.getBean("bean3");
		// System.out.println(b.run());

		ApplicationContext context4 = new AnnotationConfigApplicationContext(BeanConfig.class);
		ImageUtil imageutil = (ImageUtil) context4.getBean("imageUtil");
		imageutil.save("http://ggoreb.com/images/luffy.jpg");
	





		SpringApplication.run(DemoApplication.class, args);
	}






}
