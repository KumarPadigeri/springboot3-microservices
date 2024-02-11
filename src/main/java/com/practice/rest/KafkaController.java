package com.practice.rest;

import com.practice.service.KafkaEventPub;
import com.test.api.KafkaApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


/*
 * @Created 1/18/24
 * @Project springboot3-microservices
 * @User Kumar Padigeri
 */
@Controller
@RestController
@RequiredArgsConstructor
@Slf4j
public class KafkaController implements KafkaApi {


    private final KafkaEventPub kafkaEventPub;

    @Override
    public ResponseEntity<String> sendMsgToKafka(String message) {

        try {
            kafkaEventPub.sendMsgToTopic(message);
            return new ResponseEntity<>("Msg send successfully", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Failed to sent Msg", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> sendMsgToSpecificPartition(String message) {
        try {
            kafkaEventPub.sendMsgToSpecificPartition(message);
            return new ResponseEntity<>("Msg send successfully", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Failed to sent Msg", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
