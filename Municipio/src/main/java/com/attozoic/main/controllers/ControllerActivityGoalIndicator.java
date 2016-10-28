package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceActivityGoalIndicator;

@RestController
@RequestMapping("/activityGoalIndicators")
public class ControllerActivityGoalIndicator {

	@Autowired
	private ServiceActivityGoalIndicator serviceActivityGoalIndicator;
	
	@RequestMapping(method = RequestMethod.GET) 
	public Page<SuperEntity> getAllActivityGoalIndicators() {
		return serviceActivityGoalIndicator.findAll();
	}
	
	// Vraca izabrani cilj programa po uid-u
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getActivityGoalIndicator(@PathVariable(value="uid") Long uid) {
		return serviceActivityGoalIndicator.findOne(uid);
	}
	
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveSectors() {
		return serviceActivityGoalIndicator.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedSectors() {
		return serviceActivityGoalIndicator.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityGoalIndicator update(@RequestBody ActivityGoalIndicator activityGoalIndicator) {
		return (ActivityGoalIndicator) serviceActivityGoalIndicator.save(activityGoalIndicator);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceActivityGoalIndicator.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceActivityGoalIndicator.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceActivityGoalIndicator.unarchive(uid);
	}
}

