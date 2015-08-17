package org.webservice.reservation.handler;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.webservice.reservation.dao.MessageDao;
import org.webservice.reservation.model.Message;
import org.webservice.reservation.services.MessageService;

@Path("/message")
public class MessageHandler {

	@POST
	@Consumes(MediaType.APPLICATION_JSON) // Jersey will convert the incoming JSON format into 'Message' instance.
	@Produces(MediaType.APPLICATION_JSON)
	public Message sendMessage(Message msg) {

		MessageDao msgDao = new MessageDao();
		MessageService msgService = new MessageService();
		// send the message to customer in an email. 
		//msgService.sentEmailMessage(msg.getMessage());
		// save the message send to the user. 
		return(msgDao.saveMessageToDB(msg));
		
	}

}



