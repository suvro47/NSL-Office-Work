package com.example.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;


    public void sendEmail(String sendTo, String subject, String message) throws MessagingException, IOException {
        
    	MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
       
        Context context = new Context();
        context.setVariable("message", message);
    
        String html = templateEngine.process("newsletter-template", context);

        helper.setTo(sendTo);
        helper.setText(html, true);
        helper.setSubject(subject);
        helper.addAttachment("template-cover.png", new ClassPathResource("javabydeveloper-email.PNG"));
        

        emailSender.send(mimeMessage);
    }

}
