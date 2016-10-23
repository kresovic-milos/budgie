package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryProgrammeFinancialSource;
import com.attozoic.categories.services.ServiceCategoryProgrammeFinancialSource;

@RestController
@RequestMapping("/categoryProgrammeFinancialSources")
public class ControllerCategoryProgrammeFinancialSource {

	@Autowired
	private ServiceCategoryProgrammeFinancialSource serviceProgrammeFinancialSource;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<CategoryProgrammeFinancialSource> getAllFinances(){
		return serviceProgrammeFinancialSource.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CategoryProgrammeFinancialSource addFinance(@RequestBody CategoryProgrammeFinancialSource financialSource) {
		return serviceProgrammeFinancialSource.save(financialSource);
	}
	
}
