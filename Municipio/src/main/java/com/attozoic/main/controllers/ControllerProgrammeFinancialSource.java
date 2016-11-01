package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ProgrammeFinancialSource;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceProgrammeFinancialSource;

@RestController
@RequestMapping("/programmeFinancialSources")
public class ControllerProgrammeFinancialSource {

	@Autowired
	private ServiceProgrammeFinancialSource serviceProgrammeFinancialSource;
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getAllActivityFinancialSources(){
		return serviceProgrammeFinancialSource.findAll();
	}
	// Vraca izabrani cilj programa po uid-u
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getProgrammeGoalIndicator(@PathVariable(value="uid") Long uid) {
		return serviceProgrammeFinancialSource.findOne(uid);
	}
	
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveSectors() {
		return serviceProgrammeFinancialSource.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedSectors() {
		return serviceProgrammeFinancialSource.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProgrammeFinancialSource update(@RequestBody ProgrammeFinancialSource programmeFinancialSource) {
		return (ProgrammeFinancialSource) serviceProgrammeFinancialSource.save(programmeFinancialSource);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProgrammeFinancialSource.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProgrammeFinancialSource.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProgrammeFinancialSource.unarchive(uid);
	}

	
}
