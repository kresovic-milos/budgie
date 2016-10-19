package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.services.ServiceActivityGoalIndicator;

@RestController
@RequestMapping("/activityGoalIndicators")
public class ControllerActivityGoalIndicator {

	@Autowired
	private ServiceActivityGoalIndicator serviceActivityGoalIndicator;
	
	@RequestMapping(method = RequestMethod.GET) 
	public Page<ActivityGoalIndicator> getAllActivityGoalIndicators() {
		return serviceActivityGoalIndicator.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ActivityGoalIndicator addActivityGoalIndicator(@RequestBody ActivityGoalIndicator activityGoalIndicator) {
		return serviceActivityGoalIndicator.save(activityGoalIndicator);
	}
}
