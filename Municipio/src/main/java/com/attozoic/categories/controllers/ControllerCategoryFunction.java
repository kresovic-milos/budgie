package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryFunction;
import com.attozoic.categories.services.ServiceCategoryFunction;

@RestController
@RequestMapping("/categoryFunctions")
public class ControllerCategoryFunction {

	@Autowired
	ServiceCategoryFunction serviceFunction;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<CategoryFunction> getAllFunctions() {
		return serviceFunction.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CategoryFunction addFunction(@RequestBody CategoryFunction function) {
		return serviceFunction.save(function);
	}
}
