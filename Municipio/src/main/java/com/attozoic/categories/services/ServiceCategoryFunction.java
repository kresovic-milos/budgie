package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategoryFunction;

public interface ServiceCategoryFunction {

	Page<CategoryFunction> findAll();
	CategoryFunction save(CategoryFunction function);

}