package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
	
//	@MessageMapping("/send_notification")  // api called 
//	@SendTo("/notification_send_to/employee/2")   // dest api starting with broker prefix 
//	public Message greeting() throws Exception {
//		Thread.sleep(2000); // simulated delay
//		return new Message("You have received a new notification");
//	}
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("/send_notification")
	public void greeting() throws InterruptedException {
	   Notification message = new Notification("You have received a new notification");
	   Thread.sleep(3000);
	   simpMessagingTemplate.convertAndSend("/tafuri_news", message);
	}
	
//	@MessageMapping("/send_notification")
//	public void greeting() {
//	   Notification message = new Notification("You have received a new notification");
//	   simpMessagingTemplate.convertAndSendToUser( "suvro047@gmail.com", "/", message);
//	}
	
}
