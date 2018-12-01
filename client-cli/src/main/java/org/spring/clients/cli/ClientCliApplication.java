package org.spring.clients.cli;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class ClientCliApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ClientCliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting Cron Job!");
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setAuthenticationScheme(AuthenticationScheme.header);
		resourceDetails.setAccessTokenUri("http://localhost:9000/services/oauth/token");
		resourceDetails.setScope(Arrays.asList("toll_read"));
		resourceDetails.setClientId("client1");
		resourceDetails.setClientSecret("Secret123");
		resourceDetails.setUsername("Raj");
		resourceDetails.setPassword("pass1");
		
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);
		String token = restTemplate.getAccessToken().toString();
		
		System.out.println("Token : "+token);
		
		String s = restTemplate.getForObject("http://localhost:9001/services/tolldata", String.class);
		
		System.out.println("Result : "+s);
		
	}
}
