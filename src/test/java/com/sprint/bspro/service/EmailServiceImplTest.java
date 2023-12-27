package com.sprint.bspro.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.sprint.bspro.entity.MailStructure;

@SpringBootTest
class EmailServiceImplTest {
	@Mock
	private JavaMailSender javaMailSender;
	
	@InjectMocks
	private EmailServiceImpl emailService;

	@Test
	public void testSendSimpleMail() {
		MailStructure mailStructure=new MailStructure();
		mailStructure.setRecipient("abc@gmail.com");
		mailStructure.setSubject("Abc Subject");
		mailStructure.setMsgBody("Hello");
		
		doNothing().when(javaMailSender).send(any(SimpleMailMessage.class));
		
		String result=emailService.sendSimpleMail(mailStructure);
		assertEquals("Mail Sent Successfully...", result);
		
//		verify(javaMailSender, times(1)).send(any(SimpleMailMessage.class));
	}

}
