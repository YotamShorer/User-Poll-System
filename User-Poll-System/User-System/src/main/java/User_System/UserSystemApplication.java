package User_System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class UserSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSystemApplication.class, args);
	}

}
