package org.spring.security.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.spring.security.config.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggedInUserController {
	@Autowired
	private IAuthenticationFacade authentiCationfacade;
	
	@GetMapping("/users/current")
	public String loggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication instanceof AnonymousAuthenticationToken) {
			return null;
		}
		String userName = authentication.getName();
		return userName;
	}
	
	@GetMapping("/users/current/user")
	public String loggedInUser(Authentication authentication) {
		if(authentication instanceof AnonymousAuthenticationToken) {
			return null;
		}
		String userName = authentication.getName();
		return userName;
	}
	
	@GetMapping("/username")
	public String loggedInUser(HttpServletRequest authentication) {
		Principal principal = authentication.getUserPrincipal();
		String userName = principal.getName();
		return userName;
	}
	
	@GetMapping("/user")
	public String loggedInUserSimple() {
		return authentiCationfacade.getAuthentication().getName();
	}
}
