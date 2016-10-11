package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategoryFinancialSource;

public interface ServiceCategoryFinancialSource {

	Page<CategoryFinancialSource> findAll();
	CategoryFinancialSource save(CategoryFinancialSource finance);

}