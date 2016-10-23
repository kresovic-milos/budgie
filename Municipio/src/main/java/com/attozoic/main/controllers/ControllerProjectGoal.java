package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.services.ServiceProjectGoal;

@RestController
@RequestMapping("/projectsGoals")
public class ControllerProjectGoal {

	@Autowired
	private ServiceProjectGoal serviceProjectGoal;
	
	@RequestMapping(method = RequestMethod.GET) 
	public Page<ProjectGoal> getAllProjectGoals() {
		return serviceProjectGoal.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ProjectGoal addProjectGoal(@RequestBody ProjectGoal projectGoal) {
		return serviceProjectGoal.save(projectGoal);
	}
}
