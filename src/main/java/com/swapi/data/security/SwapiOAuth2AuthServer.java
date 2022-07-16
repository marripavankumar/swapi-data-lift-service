//package com.swapi.data.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//
//import com.swapi.data.constants.SwapiConstants;
//
//@Configuration
//@EnableAuthorizationServer
//public class SwapiOAuth2AuthServer extends AuthorizationServerConfigurerAdapter 
//{
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	@Value("${swapi.oauth.secret}")
//	private String secret;
//	
//	
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		security
//			.tokenKeyAccess("permitAll()")
//			.checkTokenAccess("isAuthenticated()")
//			.allowFormAuthenticationForClients();
//	}
//
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients
//			.inMemory()
//			.withClient(SwapiConstants.CLIENT_APP)
//			.secret(secret)
//			.authorizedGrantTypes(SwapiConstants.GRANT_TYPE_PASSWORD, SwapiConstants.GRANT_TYPE_AUTHORIZATION, SwapiConstants.GRANT_TYPE_REFRESH_TOKEN)
//			.authorities(SwapiConstants.READ_ONLY_CLIENT)
//			.scopes(SwapiConstants.READ_PROFILE_INFO)
//			.resourceIds(SwapiConstants.OAUTH2_RESOURCE)
//			.redirectUris(SwapiConstants.REDIRECT_URL)
//			.accessTokenValiditySeconds(5000)
//			.refreshTokenValiditySeconds(50000);
//	}
//}
