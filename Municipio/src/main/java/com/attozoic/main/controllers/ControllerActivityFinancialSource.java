package com.attozoic.main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceActivity;
import com.attozoic.main.services.ServiceActivityFinancialSource;

@RestController
@RequestMapping("/activityFinancialSources")
public class ControllerActivityFinancialSource {

	@Autowired
	private ServiceActivityFinancialSource serviceActivityFinancialSource;
	@Autowired
	private ServiceActivity serviceActivity;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<ActivityFinancialSource> getAllActivityFinancialSources(){
		return serviceActivityFinancialSource.findAll();
	}
	
	@RequestMapping(value="/{uid}/financialSources", method = RequestMethod.POST)
	public SuperEntity addActivityFinancialSource(@PathVariable(value="uid") Long uid, @RequestBody ActivityFinancialSource financialSource) {
				//TODO add fin src
		return null;
	}
	
}
