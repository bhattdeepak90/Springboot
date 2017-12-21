package com.sapient.service;

public interface FeaturesData {
	
	public void getfeaturesData(String uri, String method);
	
	public void buildURI(String brandName, String localeName, String featureName, String method);
	
}