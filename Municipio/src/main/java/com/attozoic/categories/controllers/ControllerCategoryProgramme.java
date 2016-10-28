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
import com.attozoic.categories.model.CategoryProgramme;
import com.attozoic.categories.model.CategoryProgrammeGoal;
import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.categories.services.ServiceCategoryProgramme;
import com.attozoic.categories.services.ServiceCategorySector;

@RestController
@RequestMapping("/categoryProgrammes")
public class ControllerCategoryProgramme {

	@Autowired
	private ServiceCategoryProgramme serviceProgramme;
	
	@Autowired
	private ServiceCategorySector serviceSector;
	
	@RequestMapping(value="/addAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAllProgrammeCategories(@RequestBody List<CategoryProgramme> programmes) {
		for (CategoryProgramme categoryProgramme : programmes) {
			Long id = categoryProgramme.getCategorySectorID();
			serviceSector.addCategoryProgramme(id, categoryProgramme);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getAllProgrammeCategories() {
		return serviceProgramme.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategorySuperEntity getCategoryProgramme(@PathVariable(value="uid") Long uid) {
		return serviceProgramme.findOne(uid);
	}

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getActiveProgrammes() {
		return serviceProgramme.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getArchivedProgrammes() {
		return serviceProgramme.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryProgramme addCategoryProgramme(@RequestBody CategoryProgramme categoryProgramme) {
		return (CategoryProgramme) serviceProgramme.save(categoryProgramme);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryProgramme updateCategoryProgramme(@RequestBody CategoryProgramme categoryProgramme) {
		return (CategoryProgramme) serviceProgramme.save(categoryProgramme);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceProgramme.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceProgramme.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceProgramme.unarchive(uid);
	}
	
	@RequestMapping(value="/{uid}/programmeGoals", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryProgrammeGoal addCategoryProgrammeGoal(@PathVariable(value="uid") Long uid, @RequestBody CategoryProgrammeGoal categoryProgrammeGoal) {
		return serviceProgramme.addCategoryProgrammeGoal(uid, categoryProgrammeGoal);
	}
	
	@RequestMapping(value="/{uid}/activities", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryActivity addCategoryActivity(@PathVariable(value="uid") Long uid, @RequestBody CategoryActivity categoryActivity) {
		return serviceProgramme.addCategoryActivity(uid, categoryActivity);
	}
}
