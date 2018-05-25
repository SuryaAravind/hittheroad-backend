package com.springboot.hittheroad.resources;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HitTheRoadResources {
	
	final String username = "hittheroadmailer@gmail.com";
	final String password = "hittheroad@2018";
	
	@RequestMapping("/home")
	String home(){
		return "Hello World!!";
	}
	
	@RequestMapping("/sendMail")
	String sendMail(){
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("hittheroadmailer@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("suryaaravind1994@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Night Witch,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		return "Mail Sent !!";
	}
	
}
