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
import com.attozoic.main.model.balance.BalanceText;
import com.attozoic.main.services.ServiceBalanceText;

@RestController
@RequestMapping("/balancesText")
public class ControllerBalanceText {

	@Autowired
	private ServiceBalanceText serviceBalanceText;
	
	//getAllBalancesText
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllBalancesText() {
		return serviceBalanceText.findAll();
	}
	
	//getBalanceText{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getBalanceText(@PathVariable(value="uid") Long uid) {
		return serviceBalanceText.findOne(uid);
	}
	
	//getActiveBalancesText
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveBalancesText() {
		return serviceBalanceText.findActive();
	}
	
	//getArchivedBalancesText
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedBalancesText() {
		return serviceBalanceText.findArchived();
	}
	
	//updateBalanceText
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public BalanceText update(@RequestBody BalanceText balanceText) {
		return (BalanceText) serviceBalanceText.update(balanceText);
	}
	
	//deleteBalanceText{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceBalanceText.delete(uid);
	}
	
	//archiveBalanceText{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceBalanceText.archive(uid);
	}
	
	//unarchiveBalanceText{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceBalanceText.unarchive(uid);
	}

	
}
