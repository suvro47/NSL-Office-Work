package com.example.demo;

import java.io.IOException;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
	
	@Autowired
    private EmailSenderService emailService;
	
	private static Logger log = LoggerFactory.getLogger(SpringBootEmailTemplateApplication.class); 
	
	@GetMapping("/home")
	public String home() {
		return "Email sending test running..............";
	}
	
	@PostMapping("/send-email")
	public void sendEmail() throws MessagingException, IOException {
		
        String sendTo = "sohel.cse.hstu@gmail.com";
        String subject = "Email with Spring boot and thymeleaf template!";
        String message = "Message Dilam na jah...";
        String attachment = "sample.png";
        
        emailService.sendEmail(sendTo, subject, message);
        emailService.sendEmailWithAttachment(sendTo, subject, message, attachment);
        log.info("END... Email sent success");
	}

}
