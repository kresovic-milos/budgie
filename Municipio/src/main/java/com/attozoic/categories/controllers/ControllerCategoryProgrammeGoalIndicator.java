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

import com.attozoic.categories.model.CategoryProgrammeGoalIndicator;
import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.categories.services.ServiceCategoryProgrammeGoal;
import com.attozoic.categories.services.ServiceCategoryProgrammeGoalIndicator;

@RestController
@RequestMapping("/categoryProgrammeGoalIndicators")
public class ControllerCategoryProgrammeGoalIndicator {

	@Autowired
	private ServiceCategoryProgrammeGoalIndicator serviceCategoryProgrammeGoalIndicator;
	
	@Autowired
	private ServiceCategoryProgrammeGoal serviceCategoryProgrammeGoal;
	
	@RequestMapping(value="/addAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAllProgrammeGoalIndicatorCategories(@RequestBody List<CategoryProgrammeGoalIndicator> programmeGoalIndicators) {
		for (CategoryProgrammeGoalIndicator categoryProgrammeGoalIndicator : programmeGoalIndicators) {
			Long id = categoryProgrammeGoalIndicator.getCategoryProgrammeGoalID();
			serviceCategoryProgrammeGoal.addCategoryProgrammeGoalIndicator(id, categoryProgrammeGoalIndicator);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getAllProgrammeGoalIndicatorCategories() {
		return serviceCategoryProgrammeGoalIndicator.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategorySuperEntity getCategoryProgrammeGoalIndicator(@PathVariable(value="uid") Long uid) {
		return serviceCategoryProgrammeGoalIndicator.findOne(uid);
	}

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getActiveProgrammeGoalIndicators() {
		return serviceCategoryProgrammeGoalIndicator.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getArchivedProgrammeGoalIndicators() {
		return serviceCategoryProgrammeGoalIndicator.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryProgrammeGoalIndicator addCategoryProgrammeGoalIndicator(@RequestBody CategoryProgrammeGoalIndicator categoryProgrammeGoalIndicator) {
		return (CategoryProgrammeGoalIndicator) serviceCategoryProgrammeGoalIndicator.save(categoryProgrammeGoalIndicator);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryProgrammeGoalIndicator updateCategoryProgrammeGoalIndicator(@RequestBody CategoryProgrammeGoalIndicator categoryProgrammeGoalIndicator) {
		return (CategoryProgrammeGoalIndicator) serviceCategoryProgrammeGoalIndicator.save(categoryProgrammeGoalIndicator);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceCategoryProgrammeGoalIndicator.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceCategoryProgrammeGoalIndicator.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceCategoryProgrammeGoalIndicator.unarchive(uid);
	}
	
}
