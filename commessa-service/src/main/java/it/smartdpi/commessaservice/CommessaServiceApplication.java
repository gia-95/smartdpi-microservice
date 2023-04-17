package it.smartdpi.commessaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommessaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommessaServiceApplication.class, args);
	}

}
