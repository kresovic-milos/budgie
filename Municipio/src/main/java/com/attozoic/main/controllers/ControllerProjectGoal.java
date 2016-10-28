package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceProjectGoal;

@RestController
@RequestMapping("/projectsGoals")
public class ControllerProjectGoal {

	@Autowired
	private ServiceProjectGoal serviceProjectGoal;
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getAllSectors() {
		return serviceProjectGoal.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectGoal getSector(@PathVariable(value="uid") Long uid) {
		return (ProjectGoal) serviceProjectGoal.findOne(uid);
	}

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveSectors() {
		return serviceProjectGoal.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedSectors() {
		return serviceProjectGoal.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectGoal save(@RequestBody ProjectGoal goal) {
		return (ProjectGoal) serviceProjectGoal.save(goal);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectGoal update(@RequestBody ProjectGoal goal) {
		return (ProjectGoal) serviceProjectGoal.save(goal);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProjectGoal.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProjectGoal.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProjectGoal.unarchive(uid);
	}
	
	@RequestMapping(value="/{uid}/indicators", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectGoalIndicator addIndicator(@PathVariable(value="uid") Long uid, @RequestBody ProjectGoalIndicator indicator) {
		return serviceProjectGoal.addIndicator(uid, indicator);
	}
}
