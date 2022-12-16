package com.login.register.appconfig;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        System.out.println("Inside configure method of WebSecurityConfig");
        httpSecurity
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/user/**").permitAll()
            .antMatchers("/h2-console/**").permitAll()
            .anyRequest().authenticated().and()
            .exceptionHandling().and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);    
        httpSecurity.cors();
        httpSecurity.headers().frameOptions().disable();
    }
}