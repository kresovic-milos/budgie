package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceActivityEconomicAccount;

@RestController
@RequestMapping("/activityEconomicAccounts")
public class ControllerActivityEconomicAccount {

	@Autowired
	private ServiceActivityEconomicAccount serviceActivityEconomicAccount;
	
//	//TEST{uid}
//	@RequestMapping(value="/{uid}/dto", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public List<DtoBalanceFinancialSourceObject> getActivityEconomicAccountDtoBalanceFinancialSourceObjectLists(@PathVariable(value="uid") Long uid) {
//		return serviceActivityEconomicAccount.getActivityEconomicAccountDtoBalanceFinancialSourceObjectLists(uid);
//	}
	
	//getAllActivityEconomicAccounts
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllActivityEconomicAccounts() {
		return serviceActivityEconomicAccount.findAll();
	}
	
	//getActivityEconomicAccount{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getActivityEconomicAccount(@PathVariable(value="uid") Long uid) {
		return serviceActivityEconomicAccount.findOne(uid);
	}
	
	//getActiveActivityEconomicAccounts
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveActivityEconomicAccounts() {
		return serviceActivityEconomicAccount.findActive();
	}
	
	//getArchivedActivityEconomicAccounts
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedActivityEconomicAccounts() {
		return serviceActivityEconomicAccount.findArchived();
	}
	
	//updateActivityEconomicAccount
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityEconomicAccount update(@RequestBody ActivityEconomicAccount activityEconomicAccount) {
		return (ActivityEconomicAccount) serviceActivityEconomicAccount.update(activityEconomicAccount);
	}
	
	//deleteActivityEconomicAccount{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceActivityEconomicAccount.delete(uid);
	}
	
	//archiveActivityEconomicAccount{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceActivityEconomicAccount.archive(uid);
	}
	
	//unarchiveActivityEconomicAccount{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceActivityEconomicAccount.unarchive(uid);
	}
	
}