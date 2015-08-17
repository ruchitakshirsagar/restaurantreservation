package org.webservice.reservation.dao;

import org.hibernate.Session;
import org.webservice.reservation.fillDummyDB.FillDummyDataToDataBase;
import org.webservice.reservation.model.Message;

public class MessageDao {

	public Message saveMessageToDB(Message newMsg) {

		// Create 'session' from 'session factory' every time you want to
		// operate on Database.
		Session session = FillDummyDataToDataBase.globalHibernateSessionFactory
				.openSession();

		// First begin a 'transaction', it can be used to save multiple objects.
		session.beginTransaction();

		// save 'MULTIPLE' object to Database.
		session.save(newMsg);

		// close 'transaction'.
		session.getTransaction().commit();
		session.close();

		
		return newMsg;

	}
	
	
}
