package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.services.ServiceEntityWithRebalances;

@RestController
@RequestMapping("/rebalances")
public class ControllerRebalance {

	@Autowired
	private ServiceEntityWithRebalances serviceEntityWithRebalances;

	@RequestMapping(value="/count", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int getRebalancesCount() {
		return serviceEntityWithRebalances.getRebalancesCount();
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addRebalance() {
		serviceEntityWithRebalances.addRebalance();
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void removeRebalance() {
		serviceEntityWithRebalances.removeRebalance();
	}
	
}
