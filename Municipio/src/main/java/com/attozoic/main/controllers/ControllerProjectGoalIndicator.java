package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceProjectGoalIndicator;

@RestController
@RequestMapping("/projectGoalIndicators")
public class ControllerProjectGoalIndicator {

	@Autowired
	private ServiceProjectGoalIndicator serviceProjectGoalIndicator;
	
	//getAllProjectGoalIndicators
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getAllProjectGoalIndicators() {
		return serviceProjectGoalIndicator.findAll();
	}
	
	//getProjectGoalIndicator{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getProjectGoalIndicator(@PathVariable(value="uid") Long uid) {
		return serviceProjectGoalIndicator.findOne(uid);
	}

	//getActiveProjectGoalIndicators
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveProjectGoalIndicators() {
		return serviceProjectGoalIndicator.findActive();
	}
	
	//getArchivedProjectGoalIndicators
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedProjectGoalIndicators() {
		return serviceProjectGoalIndicator.findArchived();
	}
	
	//updateProjectGoalIndicator
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectGoalIndicator update(@RequestBody ProjectGoalIndicator indicator) {
		return (ProjectGoalIndicator) serviceProjectGoalIndicator.update(indicator);		
	}
	
	//deleteProjectGoalIndicator{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProjectGoalIndicator.delete(uid);
	}
	
	//archiveProjectGoalIndicator{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProjectGoalIndicator.archive(uid);
	}
	
	//unarchiveProjectGoalIndicator{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProjectGoalIndicator.unarchive(uid);
	}
	
}