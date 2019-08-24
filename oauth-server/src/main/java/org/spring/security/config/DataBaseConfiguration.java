package org.spring.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataBaseConfiguration {
	@Autowired
	private Environment env;
	
	@Bean 
	public DataSource dataSource() { 
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			 dataSource.setDriverClassName(env.getProperty("jdbc.driver.class.name"));
			 dataSource.setUrl(env.getProperty("jdbc.url"));
			 dataSource.setUsername(env.getProperty("jdbc.user"));
			 dataSource.setPassword(env.getProperty("jdbc.password")); return dataSource;
		}
}
