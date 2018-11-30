package org.spring.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportController {
	
	@Autowired
	private OAuth2ClientContext oAuth2Clientcontext;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String loadHomePage() {
		return "home";
	}
	
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public String loadReports() {
		OAuth2AccessToken oauth2AccessToken = oAuth2Clientcontext.getAccessToken();
		System.out.println("Token : "+oauth2AccessToken);
		return "reports";
	} 
}
