package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryActivityFinancialSource;
import com.attozoic.categories.services.ServiceCategoryActivityFinancialSource;

@RestController
@RequestMapping("/categoryActivityFinancialSources")
public class ControllerCategoryActivityFinancialSource {

	@Autowired
	private ServiceCategoryActivityFinancialSource serviceActivityFinancialSource;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<CategoryActivityFinancialSource> getAllFinances(){
		return serviceActivityFinancialSource.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CategoryActivityFinancialSource addFinance(@RequestBody CategoryActivityFinancialSource financialSource) {
		return serviceActivityFinancialSource.save(financialSource);
	}
	
}
