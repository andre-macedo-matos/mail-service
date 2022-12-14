package org.service.mail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private SimpleMailMessage message;
	
	@PostMapping(value = "/send")
	public String send(@RequestParam(value = "name") String name,
					   @RequestParam(value = "mail") String mail, 
					   @RequestParam(value = "msg") String msg) {
		
		message.setTo(mail);
		message.setText(String.format(message.getText(), name, msg));
		
		try {
			mailSender.send(message);
		} catch (MailException e) {
			return "Ops, algo deu errado!\n Tente enviar a mensagem em outro momento.";
		}
		
		return "Email enviado com sucesso";
	}
}
