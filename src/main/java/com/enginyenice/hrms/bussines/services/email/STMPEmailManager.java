package com.enginyenice.hrms.bussines.services.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("smtpEmailService")
public class STMPEmailManager implements EmailService {
	
	@Value("${mail.smtp.starttls.enable}")
	private String startTlsEnable;
	
	@Value("${mail.smtp.host}")
	private String host;

	@Value("${mail.smtp.user}")
	private String user;
	
	@Value("${mail.smtp.password}")
	private String password;
	
	@Value("${mail.smtp.port}")
	private String port;
	
	@Value ("${mail.smtp.auth}")
	private String auth;
	
	@Override
	public boolean sendEmail(String email, String subject, String message) {
		try {
			
			String[] to = { email };
			Properties props = System.getProperties();
			
			props.put("mail.smtp.starttls.enable", startTlsEnable);
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", user);
			props.put("mail.smtp.password", password);
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.auth", auth);
			
			System.out.println(port);
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(user));
			InternetAddress[] toAddress = new InternetAddress[to.length];
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for (int i = 0; i < toAddress.length; i++) {
				mimeMessage.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}
			mimeMessage.setSubject(subject);
			mimeMessage.setText(message);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, user, password);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	

}
