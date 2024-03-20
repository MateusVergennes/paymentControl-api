package com.example.paymentsControll.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class MvcConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
