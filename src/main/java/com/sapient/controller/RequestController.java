package com.sapient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.bean.HtmlConfrigurations;
import com.sapient.restclient.RestClient;
import com.sapient.service.FeaturesData;

@RestController
public class RequestController {

	@Autowired
	public FeaturesData featuresData;
	@Autowired
	public RestClient client;
	
	@RequestMapping("/greet")
	public ResponseEntity getHtmlConfrigurations(@RequestParam("brandName") 
		String brandName, @RequestParam("localName") String localeName, @RequestParam("featureName") String featureName){
		
		List<HtmlConfrigurations> list = new ArrayList<>();
		
		//featuresData.buildURI(brandName, localeName, featureName, "GET");
		RestClient rest = new RestClient();
		//List<HtmlConfrigurations> html = rest.getRestClient();
		rest.get();
		//return new ResponseEntity<>(html, HttpStatus.OK );
		return new ResponseEntity<>( HttpStatus.OK );
	}
	
	@RequestMapping("/greeting")
	public ResponseEntity<String> getTest(){
		client.getHeaders();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
