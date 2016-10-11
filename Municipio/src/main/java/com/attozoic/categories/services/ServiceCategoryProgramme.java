package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategoryProgramme;

public interface ServiceCategoryProgramme {

	Page<CategoryProgramme> findAll();
	CategoryProgramme save(CategoryProgramme programme);

}