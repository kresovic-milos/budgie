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
import com.attozoic.main.model.balance.BalanceNumeric;
import com.attozoic.main.services.ServiceBalanceNumeric;

@RestController
@RequestMapping("/balancesNumeric")
public class ControllerBalanceNumeric {

	@Autowired
	private ServiceBalanceNumeric serviceBalanceNumeric;
	
	//getAllBalancesNumeric
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllBalancesNumeric() {
		return serviceBalanceNumeric.findAll();
	}
	
	//getBalanceNumeric{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getBalanceNumeric(@PathVariable(value="uid") Long uid) {
		return serviceBalanceNumeric.findOne(uid);
	}
	
	//getActiveBalancesNumeric
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveBalancesNumeric() {
		return serviceBalanceNumeric.findActive();
	}
	
	//getArchivedBalancesNumeric
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedBalancesNumeric() {
		return serviceBalanceNumeric.findArchived();
	}
	
	//updateBalanceNumeric
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BalanceNumeric update(@RequestBody BalanceNumeric balanceNumeric) {
		return (BalanceNumeric) serviceBalanceNumeric.update(balanceNumeric);
	}
	
	//deleteBalanceNumeric{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceBalanceNumeric.delete(uid);
	}
	
	//archiveBalanceNumeric{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceBalanceNumeric.archive(uid);
	}
	
	//unarchiveBalanceNumeric{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceBalanceNumeric.unarchive(uid);
	}

}
