package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.services.ServiceProjectGoalIndicator;

@RestController
@RequestMapping("/projectGoalIndicators")
public class ControllerProjectGoalIndicator {

	@Autowired
	private ServiceProjectGoalIndicator serviceProjectGoalIndicator;
	
	@RequestMapping(method = RequestMethod.GET) 
	public Page<ProjectGoalIndicator> getAllActivityGoalIndicators() {
		return serviceProjectGoalIndicator.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ProjectGoalIndicator addActivityGoalIndicator(@RequestBody ProjectGoalIndicator projectGoalIndicator) {
		return serviceProjectGoalIndicator.save(projectGoalIndicator);
	}
}
