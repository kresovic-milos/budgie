package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryFinancialSource;
import com.attozoic.categories.services.ServiceCategoryFinancialSource;

@RestController
@RequestMapping("/categoryFinancialSources")
public class ControllerCategoryFinancialSource {

	@Autowired
	private ServiceCategoryFinancialSource serviceFinancialSource;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<CategoryFinancialSource> getAllFinances(){
		return serviceFinancialSource.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CategoryFinancialSource addFinance(@RequestBody CategoryFinancialSource financialSource) {
		return serviceFinancialSource.save(financialSource);
	}
	
}
