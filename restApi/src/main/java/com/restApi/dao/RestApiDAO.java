package com.restApi.dao;

import java.util.Date;
import java.util.List;

import com.restApi.model.UrlShortenerDetails;

public interface RestApiDAO {

	public List<UrlShortenerDetails> viewData(String isDisabled);

	public void saveData(String absoluteUrl, Date expiry, String generatedUrl, String description);

	public String getAbsoluteUrl(String key);
}
