package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceActivityFinancialSource;

@RestController
@RequestMapping("/activityFinancialSources")
public class ControllerActivityFinancialSource {

	@Autowired
	private ServiceActivityFinancialSource serviceActivityFinancialSource;
	
	//getAllActivityFinancialSources
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getAllActivityFinancialSources(){
		return serviceActivityFinancialSource.findAll();
	}
	
	//getActivityFinancialSource{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getActivityFinancialSource(@PathVariable(value="uid") Long uid) {
		return serviceActivityFinancialSource.findOne(uid);
	}
	
	//getActiveActivityFinancialSources
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveActivityFinancialSources() {
		return serviceActivityFinancialSource.findActive();
	}
	
	//getArchivedActivityFinancialSourcers
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedActivityFinancialSourcers() {
		return serviceActivityFinancialSource.findArchived();
	}
	
	//updateActivityFinancialSource
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityFinancialSource update(@RequestBody ActivityFinancialSource activityFinancialSource) {
		return (ActivityFinancialSource) serviceActivityFinancialSource.update(activityFinancialSource);
	}
	
	//deleteActivityFinancialSource{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceActivityFinancialSource.delete(uid);
	}
	
	//archiveActivityFinancialSource{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceActivityFinancialSource.archive(uid);
	}
	
	//unarchiveActivityFinancialSource{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceActivityFinancialSource.unarchive(uid);
	}
	
}