package com.attozoic.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.SuperFinancialSource;
import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.services.ServiceBalance;

@RestController
@RequestMapping("/balances")
public class ControllerBalance {

	@Autowired
	private ServiceBalance serviceBalance; 
	
	@RequestMapping(value="{uid}/financialSources", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
		public List<SuperFinancialSource> getFinancialSources(@PathVariable(value="uid") Long uid) {
		return serviceBalance.getFinancialSources(uid);
	}
	
	//addFinancialSource to Balance{uid}
	@RequestMapping(value="/{uid}/financialSource", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperFinancialSource addFinancialSource(@PathVariable(value="uid") Long uid, @RequestBody SuperFinancialSource superFinancialSource) {
		return serviceBalance.addSuperFinancialSource(uid, superFinancialSource);
	}
	
	//getAllBalances
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllBalancesWithQuarters() {
		return serviceBalance.findAll();
	}
	
	//getBalance{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getBalanceWithQuarters(@PathVariable(value="uid") Long uid) {
		return serviceBalance.findOne(uid);
	}
	
	//getActiveBalances
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveBalancesWithQuarters() {
		return serviceBalance.findActive();
	}
	
	//getArchivedBalances
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedBalancesWithQuarters() {
		return serviceBalance.findArchived();
	}
	
	//updateBalance
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Balance update(@RequestBody Balance balanceWithQuarters) {
		return (Balance) serviceBalance.update(balanceWithQuarters);
	}
	
	//deleteBalance{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceBalance.delete(uid);
	}
	
	//archiveBalance{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceBalance.archive(uid);
	}
	
	//unarchiveBalance{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceBalance.unarchive(uid);
	}

}
