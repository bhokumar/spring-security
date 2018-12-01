package org.spring.security.controllers;

import java.util.ArrayList;

import org.spring.security.domain.TollUsage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportController {

	@Autowired
	private OAuth2ClientContext oAuth2Clientcontext;

	@Autowired
	private OAuth2RestTemplate oAuth2RestTemplate;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadHomePage() {
		return "home";
	}

	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public String loadReports(Model model) {
		OAuth2AccessToken oauth2AccessToken = oAuth2Clientcontext.getAccessToken();
		System.out.println("Token : " + oauth2AccessToken);
		ResponseEntity<ArrayList<TollUsage>> response = oAuth2RestTemplate.exchange(
				"http://localhost:9001/services/tolldata", HttpMethod.GET, null,
				new ParameterizedTypeReference<ArrayList<TollUsage>>() {
				});
		model.addAttribute("tolls", response.getBody());
		return "reports";
	}
}
