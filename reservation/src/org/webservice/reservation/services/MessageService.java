package org.webservice.reservation.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MessageService {

		 
		final String username = "dummy.trial.2000@gmail.com";
		final String password = "********";
		final String sub = "Reservation at Dessi Katta ";
		
		
		public void sentEmailMessage(String textMessage){
	  
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
	 
			Session session = Session.getInstance(props, new javax.mail.Authenticator() { protected PasswordAuthentication getPasswordAuthentication() {  return new PasswordAuthentication(username, password); } });
	 		try {

	 			
	 			
	 			Message m1 = new MimeMessage(session);
				m1.setFrom(new InternetAddress(username));
				m1.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
				m1.setSubject(sub);
				// text = message send to user
				m1.setText(textMessage);

	 
				Transport.send(m1);
	 
				//System.out.println("The mail has been send to the customer.");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
		
				
		
		
	
}
