package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryProgrammeGoalIndicator;
import com.attozoic.categories.services.ServiceCategoryProgrammeGoalIndicator;

@RestController
@RequestMapping("/categoryProgrammeGoalIndicator")
public class ControllerCategoryProgrammeGoalIndicator {

	@Autowired
	private ServiceCategoryProgrammeGoalIndicator serviceProgrammeGoalIndicator;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<CategoryProgrammeGoalIndicator> getAllProgrammeGoalIndicatorCategories() {
		return serviceProgrammeGoalIndicator.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CategoryProgrammeGoalIndicator addProgrammeGoalIndicatorCategory(@RequestBody CategoryProgrammeGoalIndicator indicator) {
		return serviceProgrammeGoalIndicator.save(indicator);
	}
	
}
