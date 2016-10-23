package com.attozoic.categories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.categories.model.CategorySector;
import com.attozoic.categories.services.ServiceCategorySector;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/categorySectors")
public class ControllerCategorySector {

	@Autowired
	private ServiceCategorySector serviceSector;

	@RequestMapping(method = RequestMethod.GET)
	public Page<CategorySector> getAllSectorCategories() {
		return serviceSector.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public CategorySector addSectorCategory(@RequestBody CategorySector sector) {
		return serviceSector.save(sector);
	}
	
}
