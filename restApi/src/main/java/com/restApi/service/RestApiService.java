package com.restApi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.restApi.model.UrlShortenerDetails;

@Service
public interface RestApiService {
	
	public List<UrlShortenerDetails> viewUrlShortnerDetails();

}
