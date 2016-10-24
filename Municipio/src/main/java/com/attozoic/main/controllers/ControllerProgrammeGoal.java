package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceProgrammeGoal;

@RestController
@RequestMapping("/programmeGoals")
public class ControllerProgrammeGoal {

	@Autowired
	private ServiceProgrammeGoal serviceProgrammeGoal;
	
	// Vraca listu svih ciljeva programa
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllProgrammeGoals() {
		return serviceProgrammeGoal.findAll();
	}
	
	// Vraca izabrani cilj programa po uid-u
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getProgrammeGoal(@PathVariable(value="uid") Long uid) {
		return serviceProgrammeGoal.findOne(uid);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProgrammeGoal update(@RequestBody ProgrammeGoal programmeGoal) {
		return (ProgrammeGoal) serviceProgrammeGoal.save(programmeGoal);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProgrammeGoal.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProgrammeGoal.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProgrammeGoal.unarchive(uid);
	}

	// Dodeljuje indicator izabranom cilju
	@RequestMapping(value="/{uid}/programmeGoalIndicator", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProgrammeGoalIndicator addProgrammeGoalIndicator(@PathVariable(value="uid") Long uid, @RequestBody ProgrammeGoalIndicator programmeGoalIndicator) {
		programmeGoalIndicator.setActiveState(ActiveState.ACTIVE);
		return serviceProgrammeGoal.addProgrammeGoalIndicator(uid, programmeGoalIndicator);
	}
	
}
