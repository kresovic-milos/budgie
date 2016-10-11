package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategoryActivity;

public interface ServiceCategoryActivity {

	Page<CategoryActivity> findAll();
	CategoryActivity save(CategoryActivity activity);
	
}
