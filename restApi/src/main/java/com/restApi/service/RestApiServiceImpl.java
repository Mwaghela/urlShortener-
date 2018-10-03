package com.restApi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.restApi.dao.RestApiDAO;
import com.restApi.model.UrlShortenerDetails;

@Service
public class RestApiServiceImpl implements RestApiService{
	
	RestApiDAO restApiDAO;
	

	public RestApiDAO getRestApiDAO() {
		return restApiDAO;
	}


	public void setRestApiDAO(RestApiDAO restApiDAO) {
		this.restApiDAO = restApiDAO;
	}


	@Override
	public List<UrlShortenerDetails> viewUrlShortnerDetails() {
		List<UrlShortenerDetails> urlList = null;
		try{
			urlList = this.restApiDAO.viewData(0);
		}catch(Exception e){
			
		}
		return urlList;
	}

}
