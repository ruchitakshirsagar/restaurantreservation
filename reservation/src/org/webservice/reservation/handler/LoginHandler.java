package org.webservice.reservation.handler;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.webservice.reservation.dao.LoginDao;
import org.webservice.reservation.model.Owner;

@Path("/login")
public class LoginHandler {

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // Jersey will convert the incoming JSON format into 'Owner' instance.
	@Produces(MediaType.APPLICATION_JSON)
	public Owner ownerLogin(Owner owner){ 
		
		LoginDao loginDao = new LoginDao();
		
		// check database and see if it is an authentic user
		// Owner obj - if user is an authentic user				
		return (loginDao.checkOwnerLogin(owner));
				   
	}
		
}


