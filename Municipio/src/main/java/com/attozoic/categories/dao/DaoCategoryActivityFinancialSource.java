package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryActivityFinancialSource;
import com.attozoic.categories.repositories.RepositoryCategoryActivityFinancialSource;

@Repository
public class DaoCategoryActivityFinancialSource {

	@Autowired
	private RepositoryCategoryActivityFinancialSource repoActivityFinancialSources;
	
	public Page<CategoryActivityFinancialSource> findAll() {
		Page<CategoryActivityFinancialSource> page = new PageImpl<>(repoActivityFinancialSources.findAll());
		return page;
	}
	
	public CategoryActivityFinancialSource save(CategoryActivityFinancialSource financialSource) {
		return repoActivityFinancialSources.save(financialSource);
	}
	
}