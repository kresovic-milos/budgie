package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.services.ServiceEconomicAccount;

@RestController
@RequestMapping("/economicAccounts")
public class ControllerEconomicAccount {

	@Autowired
	private ServiceEconomicAccount serviceEconomicAccount;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<EconomicAccount> getAllEconomies() {
		return serviceEconomicAccount.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public EconomicAccount addEconomy(@RequestBody EconomicAccount economicAccount) {
		return serviceEconomicAccount.save(economicAccount);
	}
	
}
