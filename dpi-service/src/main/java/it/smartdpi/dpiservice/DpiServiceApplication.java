package it.smartdpi.dpiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DpiServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(DpiServiceApplication.class, args);
	}

}
