package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryProgramme;
import com.attozoic.categories.repositories.RepositoryCategoryProgramme;

@Repository
public class DaoCategoryProgramme {

	@Autowired
	private RepositoryCategoryProgramme repoProgramme;
	
	public Page<CategoryProgramme> findAll() {
		Page<CategoryProgramme> page = new PageImpl<>(repoProgramme.findAll());
		return page;
	}
	
	public CategoryProgramme save(CategoryProgramme programme) {
		return repoProgramme.save(programme);
	}
	
}

