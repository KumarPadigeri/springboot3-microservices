package com.practice.service;

import com.practice.config.ApplicationProperties;
import com.twilio.rest.api.v2010.account.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
class TwilioService {

    private final ApplicationProperties applicationProperties;


    /**
     * Scheduled task to run every 30 minutes between 8:00 PM and 11:59 PM AND TRIGGER SMS.
     * The cron expression is "0 0/30 20-23 * * ?".
     *
     * <p>
     * This method is annotated with {@code @Scheduled} to indicate that it should be
     * executed based on the provided cron expression.
     * </p>
     */
    @Scheduled(cron = "0 0/30 20-23 * * ?")
    void sendSMS() {
        Message message;
        message = Message.creator(new com.twilio.type.PhoneNumber("TO_NUMBER"),
                new com.twilio.type.PhoneNumber(applicationProperties.getTwilio().getPhoneNumber()),
                "SENDING SMS FROM TWILIO").create();
        log.info("Message sent at {}", message.toString());
    }
}
