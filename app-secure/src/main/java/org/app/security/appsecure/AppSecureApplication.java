package org.app.security.appsecure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class AppSecureApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSecureApplication.class, args);
		SecurityContextHolder.getContext();
	}

}
