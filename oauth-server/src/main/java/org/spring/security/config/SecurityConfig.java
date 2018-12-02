package org.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class SecurityConfig extends GlobalAuthenticationConfigurerAdapter{
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
		//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		/*auth.inMemoryAuthentication()
			.withUser("Raj").password(encoder.encode("pass1")).roles("USER").and()
			.withUser("Bijendra").password(encoder.encode("pass2")).roles("USER","OPERATOR");*/
	}
}
