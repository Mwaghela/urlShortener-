package com.restApi.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.restApi.model.UrlShortenerDetails;

public class RestApiDAOImpl implements RestApiDAO {

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

	public List<UrlShortenerDetails> viewData(String isDisabled) {
		// TODO Auto-generated method stub
		List<UrlShortenerDetails> urlList = new ArrayList<UrlShortenerDetails>();
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		try {
			Query query = session.createQuery("from UrlShortenerDetails where isDisabled =:isDisabled");
			query.setString("isDisabled", isDisabled);
			urlList = query.list();
			tx.commit();
		} catch (Exception e) {

		} finally {
			session.close();
		}
		return urlList;
	}

	public void saveData(String absoluteUrl, Date expiry, String generatedUrl, String description) {
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		try {
			UrlShortenerDetails urlShortenerDetails = new UrlShortenerDetails();
			urlShortenerDetails.setAbsoluteUrl(absoluteUrl);
			urlShortenerDetails.setExpiry(expiry);
			urlShortenerDetails.setTinyUrl(generatedUrl);
			urlShortenerDetails.setDescription(description);
			urlShortenerDetails.setIsDisabled(0);
			session.save(urlShortenerDetails);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public String getAbsoluteUrl(String key) {
		List<UrlShortenerDetails> urlList = new ArrayList<UrlShortenerDetails>();
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		try {
			Query query = session.createQuery("from UrlShortenerDetails where tinyUrl =:tinyUrl");
			query.setString("tinyUrl", key);
			urlList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return urlList.get(0).getAbsoluteUrl();
	}
}
