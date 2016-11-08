package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceActivityGoal;

@RestController
@RequestMapping("/activityGoals")
public class ControllerActivityGoal {
	
	@Autowired
	private ServiceActivityGoal serviceActivityGoal;
	
	//getAllActivityGoals
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllActivityGoals() {
		return serviceActivityGoal.findAll();
	}
	
	//getActivityGoal{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getActivityGoal(@PathVariable(value="uid") Long uid) {
		return serviceActivityGoal.findOne(uid);
	}
	
	//getActiveActivityGoals
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveActivityGoals() {
		return serviceActivityGoal.findActive();
	}
	
	//getArchivedActivityGoals
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedActivityGoals() {
		return serviceActivityGoal.findArchived();
	}
	
	//updateActivityGoal
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityGoal update(@RequestBody ActivityGoal activityGoal) {
		return (ActivityGoal) serviceActivityGoal.update(activityGoal);
	}
	
	//deleteActivityGoal{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceActivityGoal.delete(uid);
	}
	
	//archiveActivityGoal{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceActivityGoal.archive(uid);
	}
	
	//archiveActivityGoal{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceActivityGoal.unarchive(uid);
	}

	//addActivityGoalIndicator to ActivityGoal{uid}
	@RequestMapping(value="/{uid}/activityGoalIndicators", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityGoalIndicator addActivityGoalIndicator(@PathVariable(value="uid") Long uid, @RequestBody ActivityGoalIndicator activityGoalIndicator) {
		return serviceActivityGoal.addActivityGoalIndicator(uid, activityGoalIndicator);
	}

}