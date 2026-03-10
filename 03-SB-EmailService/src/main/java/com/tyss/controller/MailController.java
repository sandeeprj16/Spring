package com.tyss.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
public class MailController {
	
	@Autowired
	private EmailService emailService;

	
	
	@GetMapping("/send")
	public String sendEmail(@RequestParam String email) {
    	emailService.sendMail(email);
		return "Email Sent, check your email : " + email;
	}
	
	@GetMapping("/send2")
	public String sendEmailTemplate(@RequestParam String email) throws IOException, MessagingException {
    	emailService.sendMailTemplate(email);
		return "Email Sent, check your email : " + email;
	}
	
	
}
