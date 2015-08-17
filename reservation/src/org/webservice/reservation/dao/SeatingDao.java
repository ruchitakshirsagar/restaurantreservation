package org.webservice.reservation.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.webservice.reservation.fillDummyDB.FillDummyDataToDataBase;
import org.webservice.reservation.model.ReservedTables;

public class SeatingDao {

	
	public ReservedTables getAllReservedTables() {

		ReservedTables reservTables = new ReservedTables();

		Session session = FillDummyDataToDataBase.globalHibernateSessionFactory
				.openSession();

		// First begin a 'transaction', it can be used to save multiple objects.
		session.beginTransaction();

		// Here you need to specify Class name and not table name. 
		Query reservationQuery = session.createQuery("SELECT res.table FROM Reservation res");
		reservTables.setBookedTables(reservationQuery.list());
		
		// Close 'transaction'.
		session.getTransaction().commit();
		session.close();
		
		return reservTables;

	}
	
}
