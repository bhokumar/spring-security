package org.spring.security.controllers;

import java.util.ArrayList;
import java.util.List;

import org.spring.security.domain.TollUsage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	
	@GetMapping(value="/tolldata")
	public List<TollUsage> getTollUsageList(){
		List<TollUsage> tollUsages = new ArrayList<>();
		tollUsages.add(new TollUsage("1", "stationId1", "licenseplate1", "timestamp1"));
		return tollUsages;
	}
}
