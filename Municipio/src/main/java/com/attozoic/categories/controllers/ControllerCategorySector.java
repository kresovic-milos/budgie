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

import com.attozoic.categories.model.CategoryProgramme;
import com.attozoic.categories.model.CategorySector;
import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.categories.services.ServiceCategorySector;

@RestController
@RequestMapping("/categorySectors")
public class ControllerCategorySector {

	@Autowired
	private ServiceCategorySector serviceSector;

	@RequestMapping(value="/addAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAllSectorCategories(@RequestBody List<CategorySector> sectors) {
		for (CategorySector categorySector : sectors) {
			serviceSector.save(categorySector);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getAllSectorCategories() {
		return serviceSector.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategorySuperEntity getCategorySector(@PathVariable(value="uid") Long uid) {
		return serviceSector.findOne(uid);
	}

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getActiveSectors() {
		return serviceSector.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getArchivedSectors() {
		return serviceSector.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategorySector addCategorySector(@RequestBody CategorySector categorySector) {
		return (CategorySector) serviceSector.save(categorySector);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategorySector updateCategorySector(@RequestBody CategorySector categorySector) {
		return (CategorySector) serviceSector.save(categorySector);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceSector.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceSector.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceSector.unarchive(uid);
	}
	
	@RequestMapping(value="/{uid}/programmes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryProgramme addCategoryProgramme(@PathVariable(value="uid") Long uid, @RequestBody CategoryProgramme categoryProgramme) {
		return serviceSector.addCategoryProgramme(uid, categoryProgramme);
	}
	
}
