package com.restApi.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.restApi.model.UrlShortenerDetails;

public class RestApiDAOImpl implements RestApiDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	Session session = null;
	Transaction tx = null;
	

	public List<UrlShortenerDetails> viewData(int isDisabled) {
		// TODO Auto-generated method stub
		List<UrlShortenerDetails> urlList=new ArrayList<UrlShortenerDetails>();
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		try{
			Query query = session.createQuery("from UrlShortenerDetails where isDisabled =:isDisabled");
			urlList = query.list();
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		return urlList;
	}
}
