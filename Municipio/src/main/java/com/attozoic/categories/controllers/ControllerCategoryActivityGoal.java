package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryActivityGoal;
import com.attozoic.categories.services.ServiceCategoryActivityGoal;

@RestController
@RequestMapping("/categoryActivityGoal")
public class ControllerCategoryActivityGoal {

	@Autowired
	private ServiceCategoryActivityGoal serviceActivityGoal;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<CategoryActivityGoal> getAllActivityGoalCategories() {
		return serviceActivityGoal.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CategoryActivityGoal addActivityGoalCategory(@RequestBody CategoryActivityGoal goal) {
		return serviceActivityGoal.save(goal);
	}
	
}
