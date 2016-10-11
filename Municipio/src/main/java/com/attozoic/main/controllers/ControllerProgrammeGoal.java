package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.services.impl.ServiceProgrammeGoal;

@RestController
@RequestMapping("/programmeGoals")
public class ControllerProgrammeGoal {

	@Autowired
	private ServiceProgrammeGoal serviceProgrammeGoal;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<ProgrammeGoal> getAllProgrammeGoals() {
		return serviceProgrammeGoal.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ProgrammeGoal save(@RequestBody ProgrammeGoal programmeGoal) {
		return serviceProgrammeGoal.save(programmeGoal);
	}
	
}
