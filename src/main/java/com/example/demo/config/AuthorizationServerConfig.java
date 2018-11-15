package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(
    //access Token이 발급된 경우만 사용할 수 있도록 설정
      AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
        				.checkTokenAccess("isAuthenticated()");
    }
 
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	//4. Authority Server의 메모리에 Client ID, Client Secret을 기반으로 코드값 발급 및 저장. redirectUrl로 보내줌
        clients.inMemory()
          .withClient("testClientId")
          .secret("testSecret")
          .authorizedGrantTypes("authorization_code")
          .authorities("USER")
          .scopes("read")
          .autoApprove(true) 
          .redirectUris("http://localhost:8888/login", "http://localhost:9090/oauthCallback", "http://localhost:9090/login")
          .accessTokenValiditySeconds(1*60); //1min  
    }

}
