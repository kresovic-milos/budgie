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
import com.attozoic.main.model.SuperFinancialSource;
import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.services.ServiceBalance;

@RestController
@RequestMapping("/balances")
public class ControllerBalance {

	@Autowired
	private ServiceBalance serviceBalance;
	
	//addQuarter1 to Balance{uid}
	@RequestMapping(value="/{uid}/quarter1", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperFinancialSource addFinancialSource_q1(@PathVariable(value="uid") Long uid, @RequestBody SuperFinancialSource superFinancialSource) {
		return serviceBalance.addQuarter1(uid, superFinancialSource);
	}
	
	//addQuarter2 to Balance{uid}
	@RequestMapping(value="/{uid}/quarter2", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperFinancialSource addFinancialSource_q2(@PathVariable(value="uid") Long uid, @RequestBody SuperFinancialSource superFinancialSource) {
		return serviceBalance.addQuarter2(uid, superFinancialSource);
	}
		
	//addQuarter3 to Balance{uid}
	@RequestMapping(value="/{uid}/quarter3", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperFinancialSource addFinancialSource_q3(@PathVariable(value="uid") Long uid, @RequestBody SuperFinancialSource superFinancialSource) {
		return serviceBalance.addQuarter3(uid, superFinancialSource);
	}
	
	//addQuarter4 to Balance{uid}
	@RequestMapping(value="/{uid}/quarter4", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperFinancialSource addFinancialSource_q4(@PathVariable(value="uid") Long uid, @RequestBody SuperFinancialSource superFinancialSource) {
		return serviceBalance.addQuarter4(uid, superFinancialSource);
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
