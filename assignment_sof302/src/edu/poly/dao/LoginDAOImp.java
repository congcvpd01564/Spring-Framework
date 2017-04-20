package edu.poly.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;


import edu.poly.bean.*;

@Repository
public class LoginDAOImp implements LoginDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	
	public boolean checkLogin(String username, String password){
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		String hql = "FROM User as o WHERE o.username=? AND o.password=?";
		Query query =session.createQuery(hql);
		query.setParameter(0, username);
		query.setParameter(1, password);
		List<User> list = query.list();
		if((list != null) && (list.size() > 0)){
			userFound = true;
		}
		session.close();
		return userFound;
	}
}
