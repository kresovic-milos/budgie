package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceProgrammeGoalIndicator;

@RestController
@RequestMapping("/programmeGoalIndicators")
public class ControllerProgrammeGoalIndicator {

	@Autowired
	private ServiceProgrammeGoalIndicator serviceProgrammeGoalIndicator;
	
	//getAllProgrammeGoalIndicators
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllProgrammeGoalIndicators() {
		return serviceProgrammeGoalIndicator.findAll();
	}
	
	//getProgrammeGoalIndicator{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getProgrammeGoalIndicator(@PathVariable(value="uid") Long uid) {
		return serviceProgrammeGoalIndicator.findOne(uid);
	}
	
	//getActiveProgrammeGoalIndicators
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveProgrammeGoalIndicators() {
		return serviceProgrammeGoalIndicator.findActive();
	}
	
	//getArchivedProgrammeGoalIndicators
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedProgrammeGoalIndicators() {
		return serviceProgrammeGoalIndicator.findArchived();
	}
	
	//updateProgrammeGoalIndicator
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProgrammeGoalIndicator update(@RequestBody ProgrammeGoalIndicator programmeGoalIndicator) {
		return (ProgrammeGoalIndicator) serviceProgrammeGoalIndicator.update(programmeGoalIndicator);
	}
	
	//deleteProgrammeGoalIndicator{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProgrammeGoalIndicator.delete(uid);
	}
	
	//archiveProgrammeGoalIndicator{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProgrammeGoalIndicator.archive(uid);
	}
	
	//unarchiveProgrammeGoalIndicator{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProgrammeGoalIndicator.unarchive(uid);
	}
	
}