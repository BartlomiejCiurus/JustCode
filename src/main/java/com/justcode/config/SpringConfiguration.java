package com.justcode.config;

import com.justcode.support.validator.ExerciseValidator;
import com.justcode.support.validator.RegisterValidator;
import com.justcode.support.validator.TutorialValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfiguration {

    @Bean(name = "registerValidator")
    @Scope(value = "prototype")
    public RegisterValidator registerValidator() {
        return new RegisterValidator();
    }

    @Bean(name = "tutorialValidator")
    @Scope(value = "prototype")
    public TutorialValidator tutorialValidator() {
        return new TutorialValidator();
    }

    @Bean(name = "exerciseValidator")
    @Scope(value = "prototype")
    public ExerciseValidator exerciseValidator() {
        return new ExerciseValidator();
    }

}
