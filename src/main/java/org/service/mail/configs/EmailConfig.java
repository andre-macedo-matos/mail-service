package org.service.mail.configs;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {
	
	@Autowired
	private Environment env;
	
	private static final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

	@Bean
	public JavaMailSender getJavaMailSender() {
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		
		mailSender.setUsername(env.getProperty("EMAIL_USER"));
		mailSender.setPassword(env.getProperty("EMAIL_PASS"));
		
		Properties mailProperties = mailSender.getJavaMailProperties();
		mailProperties.put("mail.transport.protocol", "smtp");
	    mailProperties.put("mail.smtp.auth", "true");
	    mailProperties.put("mail.smtp.starttls.enable", "true");
	    mailProperties.put("mail.debug", "true");
		
	    return mailSender;
	}
	
	@Bean
	public SimpleMailMessage templaMailMessage() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(env.getProperty("EMAIL_USER"));
		message.setBcc(env.getProperty("EMAIL_USER_BCC"));
		message.setSubject("Obrigado pelo contato!");
		message.setText("Obrigado pela sua mensagem, %s!\n\n\n" +
						"Te responderei em breve!\n\n" +
						"Mensagem original:\n %s \n\n\n" +
						"--\n" +
						"Desde já, obrigado,\n" + 
						"\tAndré Macedo");
		
		return message;
	}
}
