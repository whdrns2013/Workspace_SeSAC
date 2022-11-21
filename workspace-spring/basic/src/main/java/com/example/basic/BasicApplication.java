package com.example.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BasicApplication {
	public static void main(String[] args) {
		// ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		// Game game = (Game) context.getBean("game");
		// game.play();
		// Movie movie = (Movie) context.getBean("movie");
		// movie.play();
		// Music music = (Music) context.getBean("music");
		// music.play();

		// ((AnnotationConfigApplicationContext) context).close();

		SpringApplication.run(BasicApplication.class, args);
	}
	
}