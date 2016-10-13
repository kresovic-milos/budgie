package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryProgrammeGoal;
import com.attozoic.categories.services.ServiceCategoryProgrammeGoal;

@RestController
@RequestMapping("/categoryProgrammeGoals")
public class ControllerCategoryProgrammeGoal {

	@Autowired
	private ServiceCategoryProgrammeGoal serviceGoal;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<CategoryProgrammeGoal> getAllProgrammeGoalCategories() {
		return serviceGoal.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CategoryProgrammeGoal addProgrammeGoalCategory(@RequestBody CategoryProgrammeGoal goal) {
		return serviceGoal.save(goal);
	}
	
	
	
}
