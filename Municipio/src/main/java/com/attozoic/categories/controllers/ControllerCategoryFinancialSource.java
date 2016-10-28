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

import com.attozoic.categories.model.CategoryFinancialSource;
import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.categories.services.ServiceCategoryFinancialSource;

@RestController
@RequestMapping("/categoryProgrammeFinancialSources")
public class ControllerCategoryFinancialSource {

	@Autowired
	private ServiceCategoryFinancialSource serviceCategoryFinancialSource;
	
	@RequestMapping(value="/addAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAllFinanceCategories(@RequestBody List<CategoryFinancialSource> categoryFinanceSources) {
		for (CategoryFinancialSource categoryFinancialSource : categoryFinanceSources) {
			serviceCategoryFinancialSource.save(categoryFinancialSource);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getAllFinancialSourceCategories() {
		return serviceCategoryFinancialSource.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategorySuperEntity getCategoryFinancialSource(@PathVariable(value="uid") Long uid) {
		return serviceCategoryFinancialSource.findOne(uid);
	}

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getActiveFinancialSources() {
		return serviceCategoryFinancialSource.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getArchivedFinancialSources() {
		return serviceCategoryFinancialSource.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryFinancialSource addCategoryFinancialSource(@RequestBody CategoryFinancialSource categoryFinancialSource) {
		return (CategoryFinancialSource) serviceCategoryFinancialSource.save(categoryFinancialSource);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryFinancialSource updateCategoryFinancialSource(@RequestBody CategoryFinancialSource categoryFinancialSource) {
		return (CategoryFinancialSource) serviceCategoryFinancialSource.save(categoryFinancialSource);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceCategoryFinancialSource.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceCategoryFinancialSource.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceCategoryFinancialSource.unarchive(uid);
	}
}
