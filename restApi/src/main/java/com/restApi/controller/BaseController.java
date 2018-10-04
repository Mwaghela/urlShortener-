package com.restApi.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.restApi.model.UrlShortenerDetails;
import com.restApi.service.RestApiService;

@Controller
public class BaseController {

	RestApiService restApiService;

	public RestApiService getRestApiService() {
		return restApiService;
	}

	@Autowired
	@Qualifier(value = "restApiService")
	public void setRestApiService(RestApiService restApiService) {
		this.restApiService = restApiService;
	}

	@RequestMapping(value = "/viewTinyUrl", method = RequestMethod.POST)
	public ResponseEntity viewTinyUrl(@RequestBody String jsonData) {
		JSONObject jsonObj = new JSONObject();
		List<UrlShortenerDetails> urlList = restApiService.viewUrlShortnerDetails();
		return new ResponseEntity(urlList.toString(), HttpStatus.OK);
	}

	@RequestMapping(value = "/generateTinyUrl", method = RequestMethod.POST)
	public ResponseEntity generateTinyUrl(@RequestBody String reqData) {
		JSONObject jsonObj = new JSONObject(reqData);
		JSONObject resp = restApiService.generateTinyUrl(jsonObj);
		return new ResponseEntity(resp.toString(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	public ModelAndView redirect(@PathVariable("key") String key) {
		String resp = restApiService.getAbsoluteUrl(key);
		return new ModelAndView(new RedirectView(resp));
	}

	@RequestMapping(value = "/editTinyUrl", method = RequestMethod.POST)
	public ResponseEntity editTinyUrl(@RequestBody String reqData) {
		JSONObject jsonObj = new JSONObject();
		// Module creation under process
		return new ResponseEntity(jsonObj, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteTinyUrl", method = RequestMethod.POST)
	public ResponseEntity deleteTinyUrl(@RequestBody String reqData) {
		JSONObject jsonObj = new JSONObject();
		// Module creation under process
		return new ResponseEntity(jsonObj, HttpStatus.OK);
	}

	@RequestMapping(value = "/config", method = RequestMethod.POST)
	public ResponseEntity config(@RequestBody String reqData) {
		JSONObject jsonObj = new JSONObject();
		// Module creation under process
		return new ResponseEntity(jsonObj, HttpStatus.OK);
	}

}
