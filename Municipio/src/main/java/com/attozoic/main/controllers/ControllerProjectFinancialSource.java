package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.services.ServiceProjectFinancialSource;

@RestController
@RequestMapping("/projectFinancialSources")
public class ControllerProjectFinancialSource {

	@Autowired
	private ServiceProjectFinancialSource serviceProjectFinancialSource;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<ProjectFinancialSource> getAllProjectFinancialSources(){
		return serviceProjectFinancialSource.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ProjectFinancialSource addProjectFinancialSource(@RequestBody ProjectFinancialSource financialSource) {
		return serviceProjectFinancialSource.save(financialSource);
	}
	
}
