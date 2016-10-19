package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.services.ServiceActivityGoal;

@RestController
@RequestMapping("/activityGoals")
public class ControllerActivityGoal {

	@Autowired
	private ServiceActivityGoal serviceActivityGoal;
	
	@RequestMapping(method = RequestMethod.GET) 
	public Page<ActivityGoal> getAllActivityGoals() {
		return serviceActivityGoal.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ActivityGoal addActivityGoal(@RequestBody ActivityGoal activityGoal) {
		return serviceActivityGoal.save(activityGoal);
	}
}
