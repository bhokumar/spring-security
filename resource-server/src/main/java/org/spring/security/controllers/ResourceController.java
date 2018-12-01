package org.spring.security.controllers;

import java.util.ArrayList;
import java.util.List;

import org.spring.security.domain.TollUsage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	
	@GetMapping(value="/tolldata")
	@PreAuthorize("#oauth2.hasScope('toll_read') and hasAuthority('ROLE_OPERATOR')")
	public List<TollUsage> getTollUsageList(){
		List<TollUsage> tollUsages = new ArrayList<>();
		tollUsages.add(new TollUsage("101", "stationId1", "licenseplate1", "2018-09-30T06:38:50"));
		tollUsages.add(new TollUsage("102", "stationId2", "licenseplate2", "2018-09-30T06:38:51"));
		tollUsages.add(new TollUsage("103", "stationId3", "licenseplate3", "2018-09-30T06:38:52"));
		tollUsages.add(new TollUsage("104", "stationId4", "licenseplate4", "2018-09-30T06:38:53"));
		return tollUsages;
	}
}
