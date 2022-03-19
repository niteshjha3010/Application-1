package com.nagarro.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.LoginDetails;

@Component
public class LoginDao {

	@Autowired
	private SessionFactory sessionFactory;


	@Transactional
	public void saveLoginData(LoginDetails user) {
		Transaction transaction=null;
		try {
			
			Session session = sessionFactory.openSession();
			transaction=session.beginTransaction();

			session.save(user);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		}
	}

	@Transactional
	public boolean validateLogin(String userName, String password) {
		
		Transaction transaction=null;
		try {
			Session session = sessionFactory.openSession();
			transaction=session.beginTransaction();

			Query query = session
					.createQuery("SELECT userName FROM LoginDetails L where L.userName='" + userName + "'");
			String loginUserName = query.getSingleResult().toString();

			Query query1 = session
					.createQuery("SELECT password FROM LoginDetails L where L.password='" + password + "'");
			String loginPassword = query1.getSingleResult().toString();

			
			transaction.commit();
			if ((loginUserName.equals(userName) && loginPassword.equals(password))) {

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		}
		return false;

	}

}
