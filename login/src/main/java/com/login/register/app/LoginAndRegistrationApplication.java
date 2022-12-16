package com.login.register.app;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@EnableJpaRepositories(basePackages = {"com.login.register.dao","com.login.register.controller"})
@EntityScan(basePackages = "com.login.register.bean")
@SpringBootApplication(scanBasePackages = {"com.login.register.controller",
        "com.login.register.service",
        "com.login.register.serviceimpl",
        "com.login.register.appconfig"
})
public class LoginAndRegistrationApplication {



   public static void main(String[] args) {
            SpringApplication.run(LoginAndRegistrationApplication.class, args);
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}