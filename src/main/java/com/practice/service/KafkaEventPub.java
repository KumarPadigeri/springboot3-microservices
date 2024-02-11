package com.practice.service;

import com.test.model.StudentAO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/*
 * @Created 1/18/24
 * @Project springboot3-microservices
 * @User Kumar Padigeri
 */
@Service
@AllArgsConstructor
@Slf4j
public class KafkaEventPub {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMsgToTopic(String msg) {
        CompletableFuture<SendResult<String, Object>> response = kafkaTemplate.send("springboot-topic-new", msg);
        response.whenComplete((result, exception) -> {
            if (Objects.isNull(exception)) {
                log.info(String.format("Msg (%s) Sent successfully and offset value is %s", msg, result.getRecordMetadata().offset()));
            } else {
                log.error(String.format("Error while sending msg %s", exception.getMessage()));
            }
        });

    }


    public void sendObject(StudentAO studentAO) {
        CompletableFuture<SendResult<String, Object>> response = kafkaTemplate.send("springboot-topic-objects", UUID.randomUUID().toString(), studentAO);
        response.whenComplete((result, exception) -> {
            if (Objects.isNull(exception)) {
                log.info(String.format("Msg (%s) Sent successfully and offset value is %s", studentAO.toString(), result.getRecordMetadata().offset()));
            } else {
                log.error(String.format("Error while sending msg %s", exception.getMessage()));
            }
        });

    }

    /*
     * Send msg to specific topic
     * */
    public void sendMsgToSpecificPartition(String msg) {
        CompletableFuture<SendResult<String, Object>> response = kafkaTemplate.send("specific-topic-partition", 2, UUID.randomUUID().toString(), msg);
        response.whenComplete((result, exception) -> {
            if (Objects.isNull(exception)) {
                log.info(String.format("Msg (%s) Sent successfully and offset value is %s", msg, result.getRecordMetadata().offset()));
            } else {
                log.error(String.format("Error while sending msg %s", exception.getMessage()));
            }
        });

    }

}
