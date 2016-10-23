package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategoryProjectFinancialSource;

public interface ServiceCategoryProjectFinancialSource {

	Page<CategoryProjectFinancialSource> findAll();
	CategoryProjectFinancialSource save(CategoryProjectFinancialSource finance);

}