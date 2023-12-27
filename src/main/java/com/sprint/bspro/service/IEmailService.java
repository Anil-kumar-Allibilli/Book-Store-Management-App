package com.sprint.bspro.service;

import com.sprint.bspro.entity.MailStructure;

public interface IEmailService {
	public String sendSimpleMail(MailStructure details);
}
