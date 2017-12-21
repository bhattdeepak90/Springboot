package com.sapient.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class HtmlConf {

	@Autowired
	private HtmlConfrigurations[] configKeys;

	public HtmlConfrigurations[] getConfig() {
		return configKeys;
	}

	public void setConfig(HtmlConfrigurations[] configKeys) {
		this.configKeys = configKeys;
	}
}
