package com.practice.service;

/*
 * @Created 1/18/24
 * @Project springboot3-microservices
 * @User Kumar Padigeri
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.test.model.StudentAO;

@Service
@Slf4j
public class KafkaEventSub {

    @KafkaListener(topics = "springboot-topic-new", groupId = "sb-group")
    void Consumer(String message){
        log.info("polled message '{}' from Kafaka topic : {}",message,"springboot-topic-new");
    }






}
