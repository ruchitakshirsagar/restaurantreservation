package org.webservice.reservation.dao;

import org.hibernate.Session;
import org.webservice.reservation.fillDummyDB.FillDummyDataToDataBase;
import org.webservice.reservation.model.Owner;

public class LoginDao {

	public Owner checkOwnerLogin(Owner owner){
		
		// STEP TO SAVE DATA. 
					
		// Create 'session' from 'session factory' every time you want to operate on Database.
		Session session = FillDummyDataToDataBase.globalHibernateSessionFactory.openSession();
		
		// First begin a 'transaction', it can be used to save multiple objects.  
		session.beginTransaction();
				
		Owner retrievedOwner = (Owner) session.get(Owner.class, owner.getEmail());
						
		// close 'transaction'.  
		session.getTransaction().commit();
		session.close();
				
		// If the owner exists in the system
		if(retrievedOwner!=null && owner.equals(retrievedOwner)){
			retrievedOwner.setAuthOwner("VALID");;
			return retrievedOwner;
		}else{
			retrievedOwner = new Owner();
			retrievedOwner.setAuthOwner("NOT_VALID");;
		}
		
		return retrievedOwner;
		
	}
	
	
}
