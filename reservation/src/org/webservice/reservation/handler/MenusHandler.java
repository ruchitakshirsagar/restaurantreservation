package org.webservice.reservation.handler;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.webservice.reservation.dao.MenuDao;
import org.webservice.reservation.model.Menu;

@Path("/menu")
public class MenusHandler {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Menu> getAllMenuDetails(){
			
		MenuDao menudao = new MenuDao();
		
		return (menudao.getMenuItems());
		
	}
	
}




