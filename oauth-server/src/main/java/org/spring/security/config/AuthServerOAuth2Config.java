package org.spring.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@Configuration
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import(ServerSecurityConfig.class)
public class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {
	@Autowired
	Environment env;
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder oauthClientPasswordEncoder;

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	@Bean
	public OAuth2AccessDeniedHandler oauthAccessDeniedHandler() {
		return new OAuth2AccessDeniedHandler();
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
				.passwordEncoder(oauthClientPasswordEncoder);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(dataSource);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService);
	}
	/*
	@Bean 
	public DataSource dataSource() { 
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			 dataSource.setDriverClassName(env.getProperty("jdbc.driver.class.name"));
			 dataSource.setUrl(env.getProperty("jdbc.url"));
			 dataSource.setUsername(env.getProperty("jdbc.user"));
			 dataSource.setPassword(env.getProperty("jdbc.password")); return dataSource;
		}*/
	/*
	 * @Override public void configure(ClientDetailsServiceConfigurer clients)
	 * throws Exception { //PasswordEncoder encoder =
	 * PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 * clients.jdbc(dataSource()).build();.withClient("sampleClientId").
	 * authorizedGrantTypes("implicit").scopes("read")
	 * .autoApprove(true).and().withClient("clientIdPassword").secret("secret")
	 * .authorizedGrantTypes("password", "authorization_code",
	 * "refresh_token").scopes("read"); }
	 * 
	 * @Override public void configure(AuthorizationServerEndpointsConfigurer
	 * endPoints) throws Exception {
	 * endPoints.tokenStore(tokenStore()).authenticationManager(
	 * authenticationManager); }
	 * 
	 * @Bean public TokenStore tokenStore() { return new JdbcTokenStore(dataSource);
	 * }
	 * 
	 * @Bean
	 * 
	 * public OAuth2AccessDeniedHandler oauthAccessDeniedHandler() {
	 * 
	 * return new OAuth2AccessDeniedHandler();
	 * 
	 * }
	 * 
	 * @Override
	 * 
	 * public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
	 * 
	 * oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess(
	 * "isAuthenticated()").passwordEncoder(oauthClientPasswordEncoder);
	 * 
	 * }
	 * 
	 * @Override public void configure(ClientDetailsServiceConfigurer clients)
	 * throws Exception {
	 * 
	 * clients.jdbc(dataSource);
	 * 
	 * }
	 * 
	 * @Override public void configure(AuthorizationServerEndpointsConfigurer
	 * endpoints) {
	 * 
	 * endpoints.tokenStore(tokenStore()).authenticationManager(
	 * authenticationManager).userDetailsService(userDetailsService);
	 * 
	 * }
	 */
	/*
	 * @Bean public DataSourceInitializer dataSourceInitializer(DataSource
	 * dataSource) { DataSourceInitializer dataSourceInitializer = new
	 * DataSourceInitializer(); dataSourceInitializer.setDataSource(dataSource);
	 * dataSourceInitializer.setDatabasePopulator(databasePopulator()); return
	 * dataSourceInitializer; }
	 * 
	 * private DatabasePopulator databasePopulator() { ResourceDatabasePopulator
	 * databasePopulator = new ResourceDatabasePopulator();
	 * databasePopulator.setScripts(schemaScript); return databasePopulator; }
	 * 
	 * @Bean public DataSource dataSource() { DriverManagerDataSource dataSource =
	 * new DriverManagerDataSource();
	 * dataSource.setDriverClassName(env.getProperty("jdbc.driver.class.name"));
	 * dataSource.setUrl(env.getProperty("jdbc.url"));
	 * dataSource.setUsername(env.getProperty("jdbc.user"));
	 * dataSource.setPassword(env.getProperty("jdbc.password")); return dataSource;
	 * }
	 */
}
