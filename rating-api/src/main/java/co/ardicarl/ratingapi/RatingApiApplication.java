package co.ardicarl.ratingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(RatingApiApplication.class, args);
	}
}
