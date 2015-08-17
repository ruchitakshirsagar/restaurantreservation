package org.webservice.reservation.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.webservice.reservation.fillDummyDB.FillDummyDataToDataBase;
import org.webservice.reservation.model.ResourceInformation;

public class ResourceDao {

	public List<ResourceInformation> getAllResources() {

		List<ResourceInformation> resList = new ArrayList<ResourceInformation>();

		Session session = FillDummyDataToDataBase.globalHibernateSessionFactory
				.openSession();

		// First begin a 'transaction', it can be used to save multiple objects.
		session.beginTransaction();

		// Here you need to specify Class name and not table name. 
		Query resourceQuery = session.createQuery("FROM ResourceInformation");
		resList = resourceQuery.list();
		
		// Close 'transaction'.
		session.getTransaction().commit();
		session.close();

		return resList;

	}

	
}
