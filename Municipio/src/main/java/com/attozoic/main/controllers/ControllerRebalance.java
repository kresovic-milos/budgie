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
	ServiceEntityWithRebalances serviceEntity;

	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addRebalance() {
		serviceEntity.addRebalance();
	}
	
}
