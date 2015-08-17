package org.webservice.reservation.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.webservice.reservation.fillDummyDB.FillDummyDataToDataBase;
import org.webservice.reservation.model.Reservation;

public class ReservationDao {

	private Object reservationQuery;

	public Reservation saveReservationToDB(Reservation newRes) {
		
		// STEP TO SAVE DATA.

		// Create 'session' from 'session factory' every time you want to
		// operate on Database.
		Session session = FillDummyDataToDataBase.globalHibernateSessionFactory
				.openSession();

		// First begin a 'transaction', it can be used to save multiple objects.
		session.beginTransaction();

		// save 'MULTIPLE' object to Database.
		session.save(newRes);

		// close 'transaction'.
		session.getTransaction().commit();
		session.close();

		// FETCH DATA FROM DATABASE

		/*
		 * newRes = null; session = factory.openSession();
		 * session.beginTransaction();
		 * 
		 * newRes = (Reservation) session.get(Reservation.class, 1); // Pass the
		 * class and the primary key to retrieve it.
		 * 
		 * session.getTransaction().commit(); session.close();
		 */
		// END

		return newRes;

	}

	public List<Reservation> getAllReservations() {

		List<Reservation> listReserv = new ArrayList<Reservation>();

		Session session = FillDummyDataToDataBase.globalHibernateSessionFactory
				.openSession();

		// First begin a 'transaction', it can be used to save multiple objects.
		session.beginTransaction();
		
		// Here you need to specify Class name and not table name. 
		Query reservationQuery = session.createQuery("FROM Reservation");
		listReserv = reservationQuery.list();
		
		// Close 'transaction'.
		session.getTransaction().commit();
		session.close();

		return listReserv;

	}

}

