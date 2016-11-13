package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceProjectEconomicAccount;

@RestController
@RequestMapping("/projectEconomicAccounts")
public class ControllerProjectEconomicAccount {

	@Autowired
	private ServiceProjectEconomicAccount serviceProjectEconomicAccount;
	
	//getAllProjectEconomicAccounts
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllProjectEconomicAccounts() {
		return serviceProjectEconomicAccount.findAll();
	}
	
	//getProjectEconomicAccount{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getProjectEconomicAccount(@PathVariable(value="uid") Long uid) {
		return serviceProjectEconomicAccount.findOne(uid);
	}
	
	//getActiveProjectEconomicAccounts
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveProjectEconomicAccounts() {
		return serviceProjectEconomicAccount.findActive();
	}
	
	//getArchivedProjectEconomicAccounts
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedProjectEconomicAccounts() {
		return serviceProjectEconomicAccount.findArchived();
	}
	
	//updateProjectEconomicAccount
//	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ProjectEconomicAccount update(@RequestBody ProjectEconomicAccount projectEconomicAccount) {
//		return (ProjectEconomicAccount) serviceProjectEconomicAccount.update(projectEconomicAccount);
//	}
	
	//deleteProjectEconomicAccount{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProjectEconomicAccount.delete(uid);
	}
	
	//archiveProjectEconomicAccount{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProjectEconomicAccount.archive(uid);
	}
	
	//unarchiveProjectEconomicAccount{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProjectEconomicAccount.unarchive(uid);
	}
	
}