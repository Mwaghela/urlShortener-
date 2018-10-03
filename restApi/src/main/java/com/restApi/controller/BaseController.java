package com.restApi.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public ModelAndView load(HttpServletResponse httpServletResponse) {
		return new ModelAndView(new RedirectView("http://www.facebook.com"));
	}

	@RequestMapping(value = "/viewTinyUrl", method = RequestMethod.POST)
	public ResponseEntity viewTinyUrl(@RequestBody String jsonData) {
		JSONObject jsonObj = new JSONObject();
		List<UrlShortenerDetails> urlList = restApiService.viewUrlShortnerDetails();
		return new ResponseEntity(jsonObj.toString(), HttpStatus.OK);
	}

	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public ResponseEntity saveData(@RequestBody String jsonData) {
		JSONObject jsonObj = new JSONObject();
		return new ResponseEntity(jsonObj.toString(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{key}0", method = RequestMethod.GET)
	public ModelAndView redirect(@PathVariable("key") String key) {
		System.out.println("Key:::" + key);
		return new ModelAndView(new RedirectView("http://www.facebook.com"));
	}

}
