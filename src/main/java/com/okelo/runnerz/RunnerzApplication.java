package com.okelo.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.okelo.runnerz.run.Location;
import com.okelo.runnerz.run.Run;
import java.time.LocalDateTime;

@SpringBootApplication
public class RunnerzApplication {

	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
		log.info("Application started successfully");
	}
	@Bean
	CommandLineRunner runner(){
		return args -> {
			//log.info("CommandLineRunner executed");

			Run run = new Run(
					1,
					"Morning Run",
					LocalDateTime.now(),
					LocalDateTime.now().plusHours(1),
					5000,
					Location.OUTDOOR
			);
			log.info("Run created: {}", run);
		};
	}

}
