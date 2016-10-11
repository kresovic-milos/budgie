package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategorySector;

public interface ServiceCategorySector {
	Page<CategorySector> findAll();
	CategorySector save(CategorySector sector);
}