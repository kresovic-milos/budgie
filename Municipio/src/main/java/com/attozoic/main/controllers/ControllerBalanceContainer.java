package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.balance.BalanceContainer;
import com.attozoic.main.services.ServiceBalanceContainer;

@RestController
@RequestMapping("/balancesContainer")
public class ControllerBalanceContainer {

	@Autowired
	private ServiceBalanceContainer serviceBalanceContainer;
	
	//getAllBalancesContainer
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllBalancesContainer() {
		return serviceBalanceContainer.findAll();
	}
	
	//getBalanceContainer{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getBalanceContainer(@PathVariable(value="uid") Long uid) {
		return serviceBalanceContainer.findOne(uid);
	}
	
	//getActiveBalancesContainer
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveBalancesContainer() {
		return serviceBalanceContainer.findActive();
	}
	
	//getArchivedBalancesContainer
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedBalancesContainer() {
		return serviceBalanceContainer.findArchived();
	}
	
	//updateBalanceContainer
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BalanceContainer update(@RequestBody BalanceContainer balanceText) {
		return (BalanceContainer) serviceBalanceContainer.update(balanceText);
	}
	
	//deleteBalanceContainer{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceBalanceContainer.delete(uid);
	}
	
	//archiveBalanceContainer{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceBalanceContainer.archive(uid);
	}
	
	//unarchiveBalanceContainer{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceBalanceContainer.unarchive(uid);
	}

	
}
