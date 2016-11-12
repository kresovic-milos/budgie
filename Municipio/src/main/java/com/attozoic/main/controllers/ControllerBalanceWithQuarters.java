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
import com.attozoic.main.model.balance.BalanceWithQuarters;
import com.attozoic.main.services.ServiceBalanceWithQuarters;

@RestController
@RequestMapping("/balancesWithQuarters")
public class ControllerBalanceWithQuarters {

	@Autowired
	private ServiceBalanceWithQuarters serviceBalanceWithQuarters;
	
	//getAllBalancesWithQuarters
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllBalancesWithQuarters() {
		return serviceBalanceWithQuarters.findAll();
	}
	
	//getBalanceWithQuarters{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getBalanceWithQuarters(@PathVariable(value="uid") Long uid) {
		return serviceBalanceWithQuarters.findOne(uid);
	}
	
	//getActiveBalancesWithQuarters
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveBalancesWithQuarters() {
		return serviceBalanceWithQuarters.findActive();
	}
	
	//getArchivedBalancesWithQuarters
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedBalancesWithQuarters() {
		return serviceBalanceWithQuarters.findArchived();
	}
	
	//updateBalanceWithQuarters
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BalanceWithQuarters update(@RequestBody BalanceWithQuarters balanceWithQuarters) {
		return (BalanceWithQuarters) serviceBalanceWithQuarters.update(balanceWithQuarters);
	}
	
	//deleteBalanceWithQuarters{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceBalanceWithQuarters.delete(uid);
	}
	
	//archiveBalanceWithQuarters{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceBalanceWithQuarters.archive(uid);
	}
	
	//unarchiveBalanceWithQuarters{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceBalanceWithQuarters.unarchive(uid);
	}

	
}
