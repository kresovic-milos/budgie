package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategoryActivityFinancialSource;

public interface ServiceCategoryActivityFinancialSource {

	Page<CategoryActivityFinancialSource> findAll();
	CategoryActivityFinancialSource save(CategoryActivityFinancialSource finance);

}