package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategoryActivityGoalIndicator;
import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.categories.services.ServiceCategoryActivityGoalIndicator;

@RestController
@RequestMapping("/categoryActivityGoalIndicators")
public class ControllerCategoryActivityGoalIndicator {

	@Autowired
	private ServiceCategoryActivityGoalIndicator serviceActivityGoalIndicator;
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getAllActivityGoalIndicatorCategories() {
		return serviceActivityGoalIndicator.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategorySuperEntity getCategoryActivityGoalIndicator(@PathVariable(value="uid") Long uid) {
		return serviceActivityGoalIndicator.findOne(uid);
	}

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getActiveActivityGoalIndicators() {
		return serviceActivityGoalIndicator.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getArchivedActivityGoalIndicators() {
		return serviceActivityGoalIndicator.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryActivityGoalIndicator addCategoryActivityGoalIndicator(@RequestBody CategoryActivityGoalIndicator categoryActivityGoalIndicator) {
		return (CategoryActivityGoalIndicator) serviceActivityGoalIndicator.save(categoryActivityGoalIndicator);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryActivityGoalIndicator updateCategoryActivityGoalIndicator(@RequestBody CategoryActivityGoalIndicator categoryActivityGoalIndicator) {
		return (CategoryActivityGoalIndicator) serviceActivityGoalIndicator.save(categoryActivityGoalIndicator);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceActivityGoalIndicator.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceActivityGoalIndicator.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceActivityGoalIndicator.unarchive(uid);
	}
}
