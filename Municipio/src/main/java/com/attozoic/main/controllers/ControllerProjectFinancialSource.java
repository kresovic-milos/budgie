package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceProjectFinancialSource;

@RestController
@RequestMapping("/projectFinancialSources")
public class ControllerProjectFinancialSource {

	@Autowired
	private ServiceProjectFinancialSource serviceProjectFinancialSource;
	
	//getAllProjectFinancialSources
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getAllProjectFinancialSources() {
		return serviceProjectFinancialSource.findAll();
	}
	
	//getProjectFinancialSource{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectFinancialSource getProjectFinancialSource(@PathVariable(value="uid") Long uid) {
		return (ProjectFinancialSource) serviceProjectFinancialSource.findOne(uid);
	}
	
	//getActiveProjectFinancialSources
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveProjectFinancialSources() {
		return serviceProjectFinancialSource.findActive();
	}
	
	//getArchivedProjectFinancialSources
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedProjectFinancialSources() {
		return serviceProjectFinancialSource.findArchived();
	}
	
	//updateProjectFinancialSource
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectFinancialSource update(@RequestBody ProjectFinancialSource financialSource) {
		return (ProjectFinancialSource) serviceProjectFinancialSource.update(financialSource);
	}
	
	//deleteProjectFinancialSource{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProjectFinancialSource.delete(uid);
	}
	
	//archiveProjectFinancialSource{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProjectFinancialSource.archive(uid);
	}
	
	//unarchiveProjectFinancialSource{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProjectFinancialSource.unarchive(uid);
	}
	
}