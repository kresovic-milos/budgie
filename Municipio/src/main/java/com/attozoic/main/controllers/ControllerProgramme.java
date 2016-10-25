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
import com.attozoic.main.model.Activity;
import com.attozoic.main.model.Programme;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceProgramme;

@RestController
@RequestMapping("/programmes")
public class ControllerProgramme {

	@Autowired
	private ServiceProgramme serviceProgramme;
	
	// Vraca listu svih programa
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllProgrammes() {
		return serviceProgramme.findAll();
	}
	
	// Vraca izabrani program po uid-u
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getProgramme(@PathVariable(value="uid") Long uid) {
		return serviceProgramme.findOne(uid);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Programme save(@RequestBody Programme programme) {
		return (Programme) serviceProgramme.save(programme);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Programme update(@RequestBody Programme programme) {
		return (Programme) serviceProgramme.save(programme);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProgramme.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProgramme.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProgramme.unarchive(uid);
	}

	// Cuva programski cilj za izabrani program
	@RequestMapping(value="/{uid}/programmeGoal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProgrammeGoal addProgrammeGoal(@PathVariable(value="uid") Long uid, @RequestBody ProgrammeGoal programmeGoal) {
		programmeGoal.setActiveState(ActiveState.ACTIVE);
		return serviceProgramme.addProgrammeGoal(uid, programmeGoal);
	}
	
	@RequestMapping(value="/{uid}/activities", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Activity addActivity(@PathVariable(value="uid") Long uid, @RequestBody Activity activity) {
		return serviceProgramme.addActivity(uid, activity);
	}
}
