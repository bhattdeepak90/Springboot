package com.sapient.restclient;

import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sapient.bean.HtmlConfrigurations;

@Component
@PropertySource("bootstrap.properties")
public class RestClient {

	@Value("${app.username}")
	private String userName ;
	@Value("${app.password}")
	private String password;
	@Value("${security.user.name}")
	private String userNameS;
	//String url = "http://localhost:4502/etc/acmselfservice/tools/jcr:content.getHTMLConfig.json?brandName=axe&localeName=en_gb&featureName=egifting";
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HttpHeaders getHeaders(){
		String plainCredentails = userName + ":" + password;
		String base64credentails = new String(Base64.encodeBase64(plainCredentails.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic"+base64credentails);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}
	
	public List<HtmlConfrigurations> getRestClient(){
		System.out.println(userName);
		System.out.println(password);

		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		RestTemplate restT = restTemplateBuilder.basicAuthorization("srathore5", "123").build();
		//HtmlConf [] arr = (HtmlConf[]) restT.exchange(url, HttpMethod.GET,null, Arrays.class);
		//List<HtmlConfrigurations> list = (List<HtmlConfrigurations>) restT.exchange(url, HttpMethod.GET,null, List.class);
		
		
		
		return null;
	}
	
	public void get(){
		System.out.println(getUserName());
		System.out.println(getPassword());
		System.out.println(userNameS);
	}
}
