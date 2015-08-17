package org.webservice.reservation.handler;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.webservice.reservation.dao.ResourceDao;
import org.webservice.reservation.model.ResourceInformation;

@Path("/home")
public class ResourceHandler {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ResourceInformation> getReservation() {
		ResourceDao resDao = new ResourceDao();
		return (resDao.getAllResources());
	}
	
	
}
