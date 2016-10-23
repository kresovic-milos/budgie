package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.Project;
import com.attozoic.main.services.ServiceProject;

@RestController
@RequestMapping("/projects")
public class ControllerProject {

	@Autowired
	private ServiceProject serviceProject;
	
	@RequestMapping(method = RequestMethod.GET) 
	public Page<Project> getAllProjects() {
		return serviceProject.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Project addProject(@RequestBody Project project) {
		return serviceProject.save(project);
	}
}
