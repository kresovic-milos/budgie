package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategoryEconomicAccount;

public interface ServiceCategoryEconomicAccount {

	Page<CategoryEconomicAccount> findAll();
	CategoryEconomicAccount save(CategoryEconomicAccount economy);

}