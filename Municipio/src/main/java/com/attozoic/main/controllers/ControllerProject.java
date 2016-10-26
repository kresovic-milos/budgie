package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.model.Function;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceProject;

@RestController
@RequestMapping("/projects")
public class ControllerProject {

	@Autowired
	private ServiceProject serviceProject;
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getAllSectors() {
		return serviceProject.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Project getSector(@PathVariable(value="uid") Long uid) {
		return (Project) serviceProject.findOne(uid);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Project save(@RequestBody Project project) {
		return (Project) serviceProject.save(project);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Project update(@RequestBody Project project) {
		return (Project) serviceProject.save(project);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProject.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProject.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProject.unarchive(uid);
	}
	
	@RequestMapping(value="/{uid}/goals", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectGoal addGoal(@PathVariable(value="uid") Long uid, @RequestBody ProjectGoal goal) {
		return serviceProject.addGoal(uid, goal);
	}
	
	@RequestMapping(value="/{uid}/financialSources", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectFinancialSource addFinancialSource(@PathVariable(value="uid") Long uid, @RequestBody ProjectFinancialSource financialSource) {
		return serviceProject.addFinancialSource(uid, financialSource);
	}
	
	@RequestMapping(value="/{uid}/function", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Function addFunction(@PathVariable(value="uid") Long uid, @RequestBody Function function) {
		return serviceProject.addFunction(uid, function);
	}
	
	// addEconimcalAccount to Project
	@RequestMapping(value="/{uid}/projectEconomicAccount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EconomicAccount addEconomic(@PathVariable(value="uid") Long uid, @RequestBody EconomicAccount economicAccount) {
		return serviceProject.addEconomicAccount(uid, economicAccount);
	}
	
}
