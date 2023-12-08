package com.practice.service;


import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;


@Service
@AllArgsConstructor
@Slf4j
class SendMail {

    private JavaMailSender emailSender;

    public void sendMail(String mailsId) throws Exception {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(mailsId);
        helper.setSubject("SUBJECT LINE");
        helper.setText(
                "<p>TESTING MAIL,</p>", true); // true indicates its HTML

        // Retrieve the PDF file from the resources directory (adjusting the path as needed).
        byte[] pdfBytes = Files.readAllBytes(Paths.get("PATH/EXAMPLE.pdf"));
        Resource pdfResource = new ByteArrayResource(pdfBytes);
        helper.addAttachment("EXAMPLE.pdf", pdfResource);
        emailSender.send(message);
        log.info("Email sent successfully to {}.", mailsId);
    }


}

