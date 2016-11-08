package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceProgrammeGoal;

@RestController
@RequestMapping("/programmeGoals")
public class ControllerProgrammeGoal {

	@Autowired
	private ServiceProgrammeGoal serviceProgrammeGoal;
	
	//getAllProgrammeGoals
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllProgrammeGoals() {
		return serviceProgrammeGoal.findAll();
	}
	
	//getProgrammeGoal{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getProgrammeGoal(@PathVariable(value="uid") Long uid) {
		return serviceProgrammeGoal.findOne(uid);
	}
	
	//getActiveProgrammeGoals
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveProgrammeGoals() {
		return serviceProgrammeGoal.findActive();
	}
	
	//getArchivedProgrammeGoals
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedProgrammeGoals() {
		return serviceProgrammeGoal.findArchived();
	}
	
	//updateProgrammeGoal
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProgrammeGoal update(@RequestBody ProgrammeGoal programmeGoal) {
		return (ProgrammeGoal) serviceProgrammeGoal.update(programmeGoal);
	}
	
	//deleteProgrammeGoal{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProgrammeGoal.delete(uid);
	}
	
	//archiveProgrammeGoal{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProgrammeGoal.archive(uid);
	}
	
	//unarchiveProgrammeGoal{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProgrammeGoal.unarchive(uid);
	}

	//addProgrammeGoalIndicator to ProgrammeGoal{uid}
	@RequestMapping(value="/{uid}/programmeGoalIndicators", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProgrammeGoalIndicator addProgrammeGoalIndicator(@PathVariable(value="uid") Long uid, @RequestBody ProgrammeGoalIndicator programmeGoalIndicator) {
		return serviceProgrammeGoal.addProgrammeGoalIndicator(uid, programmeGoalIndicator);
	}
	
}
