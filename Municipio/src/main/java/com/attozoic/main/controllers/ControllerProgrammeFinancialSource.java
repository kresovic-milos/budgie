package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ProgrammeFinancialSource;
import com.attozoic.main.services.ServiceProgrammeFinancialSource;

@RestController
@RequestMapping("/programmeFinancialSources")
public class ControllerProgrammeFinancialSource {

	@Autowired
	private ServiceProgrammeFinancialSource serviceProgrammeFinancialSource;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<ProgrammeFinancialSource> getAllProgrammeFinancialSources(){
		return serviceProgrammeFinancialSource.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ProgrammeFinancialSource addProgrammeFinancialSource(@RequestBody ProgrammeFinancialSource financialSource) {
		return serviceProgrammeFinancialSource.save(financialSource);
	}
	
}
