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

import com.attozoic.categories.model.CategoryEconomicAccount;
import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.categories.services.ServiceCategoryEconomicAccount;

@RestController
@RequestMapping("/categoryEconomicAccounts")
public class ControllerCategoryEconomicAccount {

	@Autowired
	private ServiceCategoryEconomicAccount serviceEconomicAccount;
	
	@RequestMapping(value="/addAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAllExpencesCategories(@RequestBody List<CategoryEconomicAccount> categoryExpences) {
		for (CategoryEconomicAccount categoryEconomicAccount : categoryExpences) {
			serviceEconomicAccount.save(categoryEconomicAccount);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getAllEconomicAccountCategories() {
		return serviceEconomicAccount.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategorySuperEntity getCategoryEconomicAccount(@PathVariable(value="uid") Long uid) {
		return serviceEconomicAccount.findOne(uid);
	}

	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getActiveEconomicAccounts() {
		return serviceEconomicAccount.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<CategorySuperEntity> getArchivedEconomicAccounts() {
		return serviceEconomicAccount.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryEconomicAccount addCategoryEconomicAccount(@RequestBody CategoryEconomicAccount categoryEconomicAccount) {
		return (CategoryEconomicAccount) serviceEconomicAccount.save(categoryEconomicAccount);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CategoryEconomicAccount updateCategoryEconomicAccount(@RequestBody CategoryEconomicAccount categoryEconomicAccount) {
		return (CategoryEconomicAccount) serviceEconomicAccount.save(categoryEconomicAccount);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceEconomicAccount.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceEconomicAccount.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceEconomicAccount.unarchive(uid);
	}
	
}
