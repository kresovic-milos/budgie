package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryProgramme;
import com.attozoic.categories.model.CategorySector;
import com.attozoic.categories.repositories.RepositoryCategoryEntity;
import com.attozoic.categories.repositories.RepositoryCategorySector;

@Repository
public class DaoCategorySector extends DaoCategoryEntity {

	@Autowired
	private RepositoryCategorySector repoCategorySector;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoCategorySector;
	}

	@SuppressWarnings("unchecked")
	public CategoryProgramme addCategoryProgramme(Long uid, CategoryProgramme categoryProgramme) {
		CategorySector categorySector = (CategorySector) getCategoryRepoEntity().findOne(uid);
		categoryProgramme.setCategorySector(categorySector);
		categoryProgramme.setCategorySectorID(uid);
		return (CategoryProgramme) getCategoryRepoEntity().save(categoryProgramme);
	}
	
}

