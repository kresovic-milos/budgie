package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceProgrammeGoalIndicator;

@RestController
@RequestMapping("/programmeGoalIndicators")
public class ControllerProgrammeGoalIndicator {

	@Autowired
	private ServiceProgrammeGoalIndicator serviceProgrammeGoalIndicator;
	
	@RequestMapping(method = RequestMethod.GET) 
	public Page<SuperEntity> getAllProgrammeGoalIndicators() {
		return serviceProgrammeGoalIndicator.findAll();
	}
	
	// Vraca izabrani cilj programa po uid-u
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getProgrammeGoalIndicator(@PathVariable(value="uid") Long uid) {
		return serviceProgrammeGoalIndicator.findOne(uid);
	}
}
