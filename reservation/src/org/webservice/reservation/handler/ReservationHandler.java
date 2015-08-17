package org.webservice.reservation.handler;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.webservice.reservation.dao.ReservationDao;
import org.webservice.reservation.model.Reservation;


// Test using :		http://localhost:8080/reservation/webapi/userLogin/abhi

@Path("/userReservation")
public class ReservationHandler {
			
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> getReservation() {
		
		ReservationDao reserveationDao = new ReservationDao();
		
		return (reserveationDao.getAllReservations());
		
	}	
		
	/*
	 * Method:	addReservation - add the details of a new reservation to DB.
	 * Returns:	The added Reservation object.  
	 * Details:	If the user makes multiple requests for reservation, the latest entry is persisted by DB.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // Jersey will convert the incoming JSON format into 'User' instance.
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation addReservation(Reservation reserve){ 
		
		/*System.out.println("Reservaion: "+reserve.getEmail()+"  "+reserve.getFirstName()
				+"  "+reserve.getLastName() +"  "+reserve.getPartySize() +"  "+reserve.getPhone()
				+"  "+reserve.getReservationId()+"  "+reserve.getTable()+"  "+reserve.getTime()
				+"  "+reserve.getDate()
				
				);*/
		
		ReservationDao reserveationDao = new ReservationDao();
										
		return (reserveationDao.saveReservationToDB(reserve));
		 
	}
	
	
	
}	