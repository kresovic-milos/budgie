package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.Function;
import com.attozoic.main.services.ServiceFunction;

@RestController
@RequestMapping("/functions")
public class ControllerFunction {

	@Autowired
	ServiceFunction serviceFunction;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<Function> getAllFunctions() {
		return serviceFunction.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Function addFunction(@RequestBody Function function) {
		return serviceFunction.save(function);
	}
}
