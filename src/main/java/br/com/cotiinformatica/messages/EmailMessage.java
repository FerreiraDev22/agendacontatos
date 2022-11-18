package br.com.cotiinformatica.messages;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class EmailMessage {

	//atributos
	private static final String CONTA = "cotiaulajava@outlook.com";
	private static final String SENHA = "@Admin123456";
	private static final String SMTP = "smtp-mail.outlook.com";
	private static final Integer PORTA = 587;
	
	//método para realizar o envio de emails do sistema
	public void send(final String dest, final String assunto, final String mensagem) throws Exception {
		
		//Configurando a conta que fará o envio dos emails
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setUsername(CONTA);
		mailSender.setPassword(SENHA);
		mailSender.setHost(SMTP);
		mailSender.setPort(PORTA);
		
		//Configurando detalhes no envio dos emails
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.transport.protocol", "smtp");
		mailSender.setJavaMailProperties(properties);
		
		//criando a mensagem que será enviada por email
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(dest);
				message.setFrom(CONTA);
				message.setSubject(assunto);
				message.setText(mensagem);
			}
		};
		
		//enviando o email
		mailSender.send(preparator);
	}	
}



