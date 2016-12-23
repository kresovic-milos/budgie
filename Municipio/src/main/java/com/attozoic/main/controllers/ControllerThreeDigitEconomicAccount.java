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
import com.attozoic.main.model.ThreeDigitEconomicAccount;
import com.attozoic.main.services.ServiceThreeDigitEconomicAccount;

@RestController
@RequestMapping("/threeDigitEconomicAccounts")
public class ControllerThreeDigitEconomicAccount {

	@Autowired
	private ServiceThreeDigitEconomicAccount serviceThreeDigitEconomicAccount;
	
	// Three Digits for Activity - {uid}
	@RequestMapping(value="/{uid}/activity", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<ThreeDigitEconomicAccount> getActivityThreeDigitEconomicAccounts(@PathVariable(value="uid") Long uid) {
		return serviceThreeDigitEconomicAccount.getActivityThreeDigitEconomicAccounts(uid);
	}
	
	// Three Digits for Project - {uid}
	@RequestMapping(value="/{uid}/project", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<ThreeDigitEconomicAccount> getProjectThreeDigitEconomicAccounts(@PathVariable(value="uid") Long uid) {
		return serviceThreeDigitEconomicAccount.getProjectThreeDigitEconomicAccounts(uid);
	}
	
	@RequestMapping(value="/addAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAll(@RequestBody List<ThreeDigitEconomicAccount> threeDigits) {
		for (ThreeDigitEconomicAccount threeDigitEconomicAccount : threeDigits) {
			serviceThreeDigitEconomicAccount.save(threeDigitEconomicAccount);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getAllThreeDigitEconomicAccounts() {
		return serviceThreeDigitEconomicAccount.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getThreeDigitEconomicAccount(@PathVariable(value="uid") Long uid) {
		return serviceThreeDigitEconomicAccount.findOne(uid);
	}

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveThreeDigitEconomicAccounts() {
		return serviceThreeDigitEconomicAccount.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedThreeDigitEconomicAccounts() {
		return serviceThreeDigitEconomicAccount.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity addThreeDigitEconomicAccount(@RequestBody ThreeDigitEconomicAccount threeDigitEconomicAccount) {
		return (SuperEntity) serviceThreeDigitEconomicAccount.save(threeDigitEconomicAccount);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity updateThreeDigitEconomicAccount(@RequestBody ThreeDigitEconomicAccount threeDigitEconomicAccount) {
		return (SuperEntity) serviceThreeDigitEconomicAccount.save(threeDigitEconomicAccount);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceThreeDigitEconomicAccount.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceThreeDigitEconomicAccount.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceThreeDigitEconomicAccount.unarchive(uid);
	}
	
}
