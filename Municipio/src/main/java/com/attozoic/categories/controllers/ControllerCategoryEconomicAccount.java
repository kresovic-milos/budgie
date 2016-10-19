package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryEconomicAccount;
import com.attozoic.categories.services.ServiceCategoryEconomicAccount;

@RestController
@RequestMapping("/categoryEconomicAccounts")
public class ControllerCategoryEconomicAccount {

	@Autowired
	private ServiceCategoryEconomicAccount serviceEconomicAccount;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<CategoryEconomicAccount> getAllEconomies() {
		return serviceEconomicAccount.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CategoryEconomicAccount addEconomy(@RequestBody CategoryEconomicAccount economicAccount) {
		return serviceEconomicAccount.save(economicAccount);
	}
	
}
