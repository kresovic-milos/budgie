package com.attozoic.categories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryActivityGoal;
import com.attozoic.categories.model.CategoryActivityGoalIndicator;
import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.categories.services.ServiceCategoryActivity;
import com.attozoic.categories.services.ServiceCategoryActivityGoal;

@RestController
@RequestMapping("/categoryActivityGoals")
public class ControllerCategoryActivityGoal {

	@Autowired
	private ServiceCategoryActivityGoal serviceActivityGoal;
	
	@Autowired
	private ServiceCategoryActivity serviceCategoryActivity;
	
	@RequestMapping(value="/addAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAllActivityGoalCategories(@RequestBody List<CategoryActivityGoal> categoryActivityGoals) {
		for (CategoryActivityGoal categoryActivityGoal : categoryActivityGoals) {
			Long id = categoryActivityGoal.getCategoryActivityID();
			serviceCategoryActivity.addCategoryActivityGoal(id, categoryActivityGoal);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getAllActivityGoalCategories() {
		return serviceActivityGoal.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategorySuperEntity getCategoryActivityGoal(@PathVariable(value="uid") Long uid) {
		return serviceActivityGoal.findOne(uid);
	}

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getActiveActivityGoals() {
		return serviceActivityGoal.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getArchivedActivityGoals() {
		return serviceActivityGoal.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryActivityGoal addCategoryActivityGoal(@RequestBody CategoryActivityGoal categoryActivityGoal) {
		return (CategoryActivityGoal) serviceActivityGoal.save(categoryActivityGoal);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryActivityGoal updateCategoryActivityGoal(@RequestBody CategoryActivityGoal categoryActivityGoal) {
		return (CategoryActivityGoal) serviceActivityGoal.save(categoryActivityGoal);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceActivityGoal.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceActivityGoal.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceActivityGoal.unarchive(uid);
	}
	
	@RequestMapping(value="/{uid}/activityGoalIndicators", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryActivityGoalIndicator addCategoryActivityGoalIndicator(@PathVariable(value="uid") Long uid, @RequestBody CategoryActivityGoalIndicator categoryActivityGoalIndicator) {
		return serviceActivityGoal.addCategoryActivityGoalIndicator(uid, categoryActivityGoalIndicator);
	}
}
