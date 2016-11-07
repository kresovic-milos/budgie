package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectEconomicAccount;
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

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveSectors() {
		return serviceProject.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedSectors() {
		return serviceProject.findArchived();
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
	
	@RequestMapping(value="/{uid}/projectGoals", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectGoal addProjectGoal(@PathVariable(value="uid") Long uid, @RequestBody ProjectGoal goal) {
		return serviceProject.addProjectGoal(uid, goal);
	}
	
	@RequestMapping(value="/{uid}/financialSources", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectFinancialSource addProjectFinancialSource(@PathVariable(value="uid") Long uid, @RequestBody ProjectFinancialSource financialSource) {
		return serviceProject.addProjectFinancialSource(uid, financialSource);
	}
	
	// addEconimcalAccount to Project
	@RequestMapping(value="/{uid}/projectEconomicAccounts", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectEconomicAccount addProjectEconomicAccount(@PathVariable(value="uid") Long uid, @RequestBody ProjectEconomicAccount projectEconomicAccount) {
		return serviceProject.addProjectEconomicAccount(uid, projectEconomicAccount);
	}
	
}
