package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryActivityGoalIndicator;
import com.attozoic.categories.services.ServiceCategoryActivityGoalIndicator;

@RestController
@RequestMapping("/category_activity_goal_indicator")
public class ControllerCategoryActivityGoalIndicator {

	@Autowired
	private ServiceCategoryActivityGoalIndicator serviceActivityGoalIndicator;
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<CategoryActivityGoalIndicator> getAllActivityGoalIndicatorCategories() {
		return serviceActivityGoalIndicator.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public CategoryActivityGoalIndicator save(@RequestBody CategoryActivityGoalIndicator indicator) {
		return serviceActivityGoalIndicator.save(indicator);
	}
}
