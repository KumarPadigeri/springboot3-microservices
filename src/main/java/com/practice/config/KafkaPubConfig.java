package com.practice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Created 1/18/24
 * @Project springboot3-microservices
 * @User Kumar Padigeri
 */
@Configuration
public class KafkaPubConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("springboot-topic-new",3,(short) 1);
    }





}
