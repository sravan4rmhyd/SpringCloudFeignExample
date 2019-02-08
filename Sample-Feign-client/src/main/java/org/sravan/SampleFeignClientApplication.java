package org.sravan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SampleFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleFeignClientApplication.class, args);
	}

}
