package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategoryProgrammeFinancialSource;

public interface ServiceCategoryProgrammeFinancialSource {

	Page<CategoryProgrammeFinancialSource> findAll();
	CategoryProgrammeFinancialSource save(CategoryProgrammeFinancialSource finance);

}