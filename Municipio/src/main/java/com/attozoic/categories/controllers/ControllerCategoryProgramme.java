package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryProgramme;
import com.attozoic.categories.services.ServiceCategoryProgramme;

@RestController
@RequestMapping("/categoryProgrammes")
public class ControllerCategoryProgramme {

	@Autowired
	private ServiceCategoryProgramme serviceProgramme;
	
	@RequestMapping(method = RequestMethod.GET) 
	public Page<CategoryProgramme> getAllProgrammeCategories() {
		return serviceProgramme.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CategoryProgramme addProgrammeCategory(@RequestBody CategoryProgramme programme) {
		return serviceProgramme.save(programme);
	}
}
