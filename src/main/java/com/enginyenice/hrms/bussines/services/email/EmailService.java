package com.enginyenice.hrms.bussines.services.email;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
	boolean sendEmail(String email,String subject, String message);
}
