package com.restApi.dao;

import java.util.List;

import com.restApi.model.UrlShortenerDetails;

public interface RestApiDAO {

	public List<UrlShortenerDetails> viewData(int isDisabled);
	
}
