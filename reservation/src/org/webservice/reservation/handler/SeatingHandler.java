package org.webservice.reservation.handler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.webservice.reservation.dao.SeatingDao;
import org.webservice.reservation.model.ReservedTables;


@Path("/seating")
public class SeatingHandler {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ReservedTables getReservedTables() {
				
		SeatingDao tableDao = new SeatingDao();
		 
		return (tableDao.getAllReservedTables());
	}
	
	
}
