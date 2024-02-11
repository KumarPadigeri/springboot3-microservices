package com.practice.service;

/*
 * @Created 1/18/24
 * @Project springboot3-microservices
 * @User Kumar Padigeri
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaEventSub {

    @KafkaListener(topics = "springboot-topic-new", groupId = "sb-group")
    void Consumer(String message) {
        log.info("polled message '{}' from Kafaka topic : {}", message, "springboot-topic-new");
    }


    /*
    consume msg from specific partition.
     */
    @KafkaListener(topics = "specific-topic-partition", groupId = "partition2-group",
            topicPartitions = {@TopicPartition(topic = "specific-topic-partition", partitions = "2")})
    void ConsumerFromSpecificPartition(String message) {
        log.info("polled message '{}' from Kafaka topic : {}", message, "springboot-topic-new");
    }


}
