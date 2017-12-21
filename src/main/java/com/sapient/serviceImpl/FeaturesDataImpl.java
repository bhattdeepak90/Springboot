package com.sapient.serviceImpl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sapient.service.FeaturesData;

@Service
public class FeaturesDataImpl implements FeaturesData {

private static final Logger log = LoggerFactory.getLogger(FeaturesDataImpl	.class);
	
	public void getfeaturesData(String uri, String method){
		try {
			URL url = new URL(uri);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setRequestProperty("Accept", "application/json");
			
			if(connection.getResponseCode() != 200){
				throw new RuntimeException("");
			}
			
		} catch (IOException e) {
			log.error("Error occurred..");
		}
		
	}
	
	public void buildURI(String brandName, String localeName, String featureName, String method){
		String baseUri = "http://localhost:4502/etc/acmselfservice/tools/jcr:content.getHTMLConfig.json";
		String query = "?";
		String params = "brandName=" + brandName +"&localeName=" + localeName + "featureName=" + featureName;
		
		getfeaturesData(baseUri+query+params, method);
	}
}
