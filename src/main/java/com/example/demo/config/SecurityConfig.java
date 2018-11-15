package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		//2. 로그인 권한을 가지고 있지 않은 경우 로그인 페이지로 이동. 허가되는 페이지 URL 설정
        http
          .requestMatchers()
          .antMatchers("/login**", "/oauth/authorize", "/css/**", "/js/**", "/exit")
          .and()
          .authorizeRequests()
          .and()
          .formLogin()
          .loginProcessingUrl("/login")
		  .loginPage("/loginForm")
          .permitAll()
          /*
          .and()
          .csrf()
          .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/user*"))
		  .disable()
		  */
          ;
        
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	//3. DB에 접속하여 로그인 가능 여부 체크
    	auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){ 
        return new BCryptPasswordEncoder(); 
    }
    
}
