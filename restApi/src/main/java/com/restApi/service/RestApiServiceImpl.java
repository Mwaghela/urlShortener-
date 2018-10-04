package com.restApi.service;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.restApi.dao.RestApiDAO;
import com.restApi.model.UrlShortenerDetails;
import com.restApi.util.Constants;
import com.restApi.util.GenerateTinyUrl;
import com.restApi.util.UtilMaster;

@Service
public class RestApiServiceImpl implements RestApiService {

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
		try {
			urlList = this.restApiDAO.viewData("0");
		} catch (Exception e) {

		}
		return urlList;
	}

	@Override
	public JSONObject generateTinyUrl(JSONObject reqData) {
		List<UrlShortenerDetails> urlList = null;
		String absoluteUrl = reqData.getJSONObject("data").getString("absoluteUrl");
		String description = reqData.getJSONObject("data").getString("description");
		Date expiry = UtilMaster.convertStringToDate(reqData.getJSONObject("data").getString("expiry"));

		GenerateTinyUrl generateTinyUrl = GenerateTinyUrl.getInstance();
		String generatedUrl = generateTinyUrl.generateTinyUrl(15);
		try {
			this.restApiDAO.saveData(absoluteUrl, expiry, generatedUrl, description);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("data", new JSONObject().put("tinyUrl", generatedUrl));
		jsonObj.put("status", Constants.SUCCESS);
		jsonObj.put("message", "Tiny Url Created successfully!!!");
		return null;
	}

	public String getAbsoluteUrl(String key) {
		return this.restApiDAO.getAbsoluteUrl(key);
	}

}
