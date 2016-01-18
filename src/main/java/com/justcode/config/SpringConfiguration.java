package com.justcode.config;

import com.justcode.support.validator.RegisterValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean(name = "registerValidator")
    public RegisterValidator registerValidator(){
        return new RegisterValidator();
    }

}
