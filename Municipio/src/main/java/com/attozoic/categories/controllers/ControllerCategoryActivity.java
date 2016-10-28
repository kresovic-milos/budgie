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

import com.attozoic.categories.model.CategoryActivity;
import com.attozoic.categories.model.CategoryActivityGoal;
import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.categories.services.ServiceCategoryActivity;
import com.attozoic.categories.services.ServiceCategoryProgramme;

@RestController
@RequestMapping("/categoryActivities")
public class ControllerCategoryActivity {

	@Autowired
	ServiceCategoryActivity serviceCategoryActivity;

	@Autowired
	ServiceCategoryProgramme serviceCategoryProgramme;
	
	@RequestMapping(value="/addAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAllActivityCategories(@RequestBody List<CategoryActivity> categoryActivities) {
		for (CategoryActivity categoryActivity : categoryActivities) {
			Long id = categoryActivity.getCategoryProgrammeID();
			serviceCategoryProgramme.addCategoryActivity(id, categoryActivity);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getAllActivityCategories() {
		return serviceCategoryActivity.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategorySuperEntity getCategoryActivity(@PathVariable(value="uid") Long uid) {
		return serviceCategoryActivity.findOne(uid);
	}

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getActiveActivities() {
		return serviceCategoryActivity.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getArchivedActivities() {
		return serviceCategoryActivity.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryActivity addCategoryActivity(@RequestBody CategoryActivity categoryActivity) {
		return (CategoryActivity) serviceCategoryActivity.save(categoryActivity);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryActivity updateCategoryActivity(@RequestBody CategoryActivity categoryActivity) {
		return (CategoryActivity) serviceCategoryActivity.save(categoryActivity);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceCategoryActivity.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceCategoryActivity.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceCategoryActivity.unarchive(uid);
	}
	
	@RequestMapping(value="/{uid}/activityGoals", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryActivityGoal addCategoryActivityGoal(@PathVariable(value="uid") Long uid, @RequestBody CategoryActivityGoal categoryActivityGoal) {
		return serviceCategoryActivity.addCategoryActivityGoal(uid, categoryActivityGoal);
	}
		
}
