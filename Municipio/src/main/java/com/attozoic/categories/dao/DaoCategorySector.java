package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategorySector;
import com.attozoic.categories.repositories.RepositoryCategorySector;

@Repository
public class DaoCategorySector {

	@Autowired
	private RepositoryCategorySector repoSector;
	
	public Page<CategorySector> findAll() {
		Page<CategorySector> page = new PageImpl<>(repoSector.findAll());
		return page;
	}

	public CategorySector save(CategorySector sector) {
		return repoSector.save(sector);
	}
	
	
	
}

