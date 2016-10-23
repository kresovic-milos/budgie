package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryProgrammeFinancialSource;
import com.attozoic.categories.repositories.RepositoryCategoryProgrammeFinancialSource;

@Repository
public class DaoCategoryProgrammeFinancialSource {

	@Autowired
	private RepositoryCategoryProgrammeFinancialSource repoProgrammeFinancialSources;
	
	public Page<CategoryProgrammeFinancialSource> findAll() {
		Page<CategoryProgrammeFinancialSource> page = new PageImpl<>(repoProgrammeFinancialSources.findAll());
		return page;
	}
	
	public CategoryProgrammeFinancialSource save(CategoryProgrammeFinancialSource financialSource) {
		return repoProgrammeFinancialSources.save(financialSource);
	}
	
}
