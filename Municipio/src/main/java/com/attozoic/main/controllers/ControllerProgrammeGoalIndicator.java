package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.services.ServiceProgrammeGoalIndicator;

@RestController
@RequestMapping("/programmeGoalIndicators")
public class ControllerProgrammeGoalIndicator {

	@Autowired
	private ServiceProgrammeGoalIndicator serviceProgrammeGoalIndicator;
	
	@RequestMapping(method = RequestMethod.GET) 
	public Page<ProgrammeGoalIndicator> getAllProgrammeGoalIndicators() {
		return serviceProgrammeGoalIndicator.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ProgrammeGoalIndicator addProgrammeGoalIndicator(@RequestBody ProgrammeGoalIndicator programmeGoalIndicator) {
		return serviceProgrammeGoalIndicator.save(programmeGoalIndicator);
	}
}
