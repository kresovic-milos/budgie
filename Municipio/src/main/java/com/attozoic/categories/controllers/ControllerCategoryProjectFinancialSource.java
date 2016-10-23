package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryProjectFinancialSource;
import com.attozoic.categories.services.ServiceCategoryProjectFinancialSource;

@RestController
@RequestMapping("/categoryProjectFinancialSources")
public class ControllerCategoryProjectFinancialSource {

	@Autowired
	private ServiceCategoryProjectFinancialSource serviceCategoryProjectFinancialSource;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<CategoryProjectFinancialSource> getAllFinances(){
		return serviceCategoryProjectFinancialSource.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CategoryProjectFinancialSource addFinance(@RequestBody CategoryProjectFinancialSource financialSource) {
		return serviceCategoryProjectFinancialSource.save(financialSource);
	}
	
}
