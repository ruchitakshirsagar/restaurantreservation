package org.webservice.reservation.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.webservice.reservation.fillDummyDB.FillDummyDataToDataBase;
import org.webservice.reservation.model.Menu;

public class MenuDao {

	public List<Menu> getMenuItems(){
		
		List<Menu> menus  = new ArrayList<Menu>();
		
		// Create 'session' from 'session factory' every time you want to operate on Database.
		Session session = FillDummyDataToDataBase.globalHibernateSessionFactory.openSession();
		
		// First begin a 'transaction', it can be used to save multiple objects.  
		session.beginTransaction();

		Query menuQuery = session.createQuery("FROM Menu");
		menus = menuQuery.list();
				
		for(int j=0;j<menus.size(); j++){
			System.out.println("desc:"+menus.get(j).getDescriptions());
		}
		
		// close 'transaction'.  
		session.getTransaction().commit();
		session.close();
						
		return menus;
		
	}
	
	
	public List<String> formatData(List<Menu> menus){
		
		List<String> data = new ArrayList<String>();
		for(int i=0; i<menus.size(); i++){
			StringBuffer menu = new StringBuffer();
			menu.append(menus.get(i).getMenuCategory());
			for(int j=0;j<menus.get(i).getDescriptions().size(); j++){
				menu.append("@"+menus.get(i).getDescriptions().get(j));
			}
			data.add(menu.toString());
		}
		
		
		return data;		
	}
	
	
	
}
