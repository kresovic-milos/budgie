package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.FinancialSource;
import com.attozoic.main.services.ServiceFinancialSource;

@RestController
@RequestMapping("/financialSources")
public class ControllerFinancialSource {

	@Autowired
	private ServiceFinancialSource serviceFinancialSource;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<FinancialSource> getAllFinancialSources(){
		return serviceFinancialSource.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public FinancialSource addFinancialSource(@RequestBody FinancialSource financialSource) {
		return serviceFinancialSource.save(financialSource);
	}
	
}
