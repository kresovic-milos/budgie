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

import com.attozoic.categories.model.CategoryProgrammeGoal;
import com.attozoic.categories.model.CategoryProgrammeGoalIndicator;
import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.categories.services.ServiceCategoryProgramme;
import com.attozoic.categories.services.ServiceCategoryProgrammeGoal;

@RestController
@RequestMapping("/categoryProgrammeGoals")
public class ControllerCategoryProgrammeGoal {

	@Autowired
	private ServiceCategoryProgrammeGoal serviceCategoryGoal;
		
	@Autowired
	private ServiceCategoryProgramme serviceCategoryProgramme;
	
	@RequestMapping(value="/addAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAllProgrammeGoalCategories(@RequestBody List<CategoryProgrammeGoal> programmeGoals) {
		for (CategoryProgrammeGoal categoryProgrammeGoal : programmeGoals) {
			Long id = categoryProgrammeGoal.getCategoryProgrammeID();
			serviceCategoryProgramme.addCategoryProgrammeGoal(id, categoryProgrammeGoal);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getAllProgrammeGoalCategories() {
		return serviceCategoryGoal.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategorySuperEntity getCategoryProgrammeGoal(@PathVariable(value="uid") Long uid) {
		return serviceCategoryGoal.findOne(uid);
	}

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getActiveProgrammeGoals() {
		return serviceCategoryGoal.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getArchivedProgrammeGoals() {
		return serviceCategoryGoal.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryProgrammeGoal addCategoryProgrammeGoal(@RequestBody CategoryProgrammeGoal categoryProgrammeGoal) {
		return (CategoryProgrammeGoal) serviceCategoryGoal.save(categoryProgrammeGoal);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryProgrammeGoal updateCategoryProgrammeGoal(@RequestBody CategoryProgrammeGoal categoryProgrammeGoal) {
		return (CategoryProgrammeGoal) serviceCategoryGoal.save(categoryProgrammeGoal);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceCategoryGoal.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceCategoryGoal.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceCategoryGoal.unarchive(uid);
	}
	
	@RequestMapping(value="/{uid}/programmeGoalIndicators", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryProgrammeGoalIndicator addCategoryProgrammeGoalIndicator(@PathVariable(value="uid") Long uid, @RequestBody CategoryProgrammeGoalIndicator categoryProgrammeGoalIndicator) {
		return serviceCategoryGoal.addCategoryProgrammeGoalIndicator(uid, categoryProgrammeGoalIndicator);
	}
	
}
