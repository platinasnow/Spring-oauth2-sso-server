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
        http
          .requestMatchers()
          .antMatchers("/login**", "/oauth/authorize", "/css/**", "/js/**")
          .and()
          .authorizeRequests()
          //.antMatchers("/login**", "/css/**", "/webjars/**").permitAll()
          //.anyRequest().authenticated()
          .and()
          .formLogin()
          .loginProcessingUrl("/login")
		  .loginPage("/loginForm")
          .permitAll();
        
		/*
		http
		.authorizeRequests()
			.antMatchers("/login**", "/webjars/**", "/css/**", "/userInfo").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginProcessingUrl("/login")
			.loginPage("/loginForm")
			.permitAll()
			.and()
		.csrf()
			.requireCsrfProtectionMatcher(new AntPathRequestMatcher("/user*"))
			.disable()
		.logout()
			.permitAll();
			*/
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){ 
        return new BCryptPasswordEncoder(); 
    }
    
}
