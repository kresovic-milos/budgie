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
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.balance.BalanceEconomicAccount;
import com.attozoic.main.services.ServiceBalanceEconomicAccount;

@RestController
@RequestMapping("/balancesEconomicAccount")
public class ControllerBalanceEconomicAccount {

	@Autowired
	private ServiceBalanceEconomicAccount serviceBalanceEconomicAccount;
	
	//getAllBalancesEconomicAccount
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllBalancesEconomicAccount() {
		return serviceBalanceEconomicAccount.findAll();
	}
	
	//getBalanceEconomicAccount{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getBalanceEconomicAccount(@PathVariable(value="uid") Long uid) {
		return serviceBalanceEconomicAccount.findOne(uid);
	}
	
	//getActiveBalancesEconomicAccount
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveBalancesEconomicAccount() {
		return serviceBalanceEconomicAccount.findActive();
	}
	
	//getArchivedBalancesEconomicAccount
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedBalancesEconomicAccount() {
		return serviceBalanceEconomicAccount.findArchived();
	}
	
	//updateBalanceEconomicAccount
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BalanceEconomicAccount update(@RequestBody BalanceEconomicAccount balanceEconomicAccount) {
		return (BalanceEconomicAccount) serviceBalanceEconomicAccount.update(balanceEconomicAccount);
	}
	
	//deleteBalanceEconomicAccount{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceBalanceEconomicAccount.delete(uid);
	}
	
	//archiveBalanceEconomicAccount{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceBalanceEconomicAccount.archive(uid);
	}
	
	//unarchiveBalanceEconomicAccount{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceBalanceEconomicAccount.unarchive(uid);
	}

	//addActivityFinancialSource to BalanceEconomicAccount{uid}
	@RequestMapping(value="/{uid}/activityFinancialSources", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityFinancialSource addActivityFinancialSource(@PathVariable(value="uid") Long uid, @RequestBody ActivityFinancialSource activityFinancialSource) {
		return serviceBalanceEconomicAccount.addActivityFinancialSource(uid, activityFinancialSource);
	}
	
	//addProjectFinancialSource to BalanceEconomicAccount{uid}
	@RequestMapping(value="/{uid}/projectFinancialSources", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProjectFinancialSource addProjectFinancialSource(@PathVariable(value="uid") Long uid, @RequestBody ProjectFinancialSource projectFinancialSource) {
		return serviceBalanceEconomicAccount.addProjectFinancialSource(uid, projectFinancialSource);
	}
	
}
