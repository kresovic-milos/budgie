package com.attozoic.categories.services;

import com.attozoic.categories.model.CategoryProgramme;

public interface ServiceCategorySector extends ServiceCategoryEntity {
	CategoryProgramme addCategoryProgramme(Long uid, CategoryProgramme categoryProgramme);
}