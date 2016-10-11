package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryFinancialSource;
import com.attozoic.categories.repositories.RepositoryCategoryFinancialSource;

@Repository
public class DaoCategoryFinancialSource {

	@Autowired
	private RepositoryCategoryFinancialSource repoFinancialSources;
	
	public Page<CategoryFinancialSource> findAll() {
		Page<CategoryFinancialSource> page = new PageImpl<>(repoFinancialSources.findAll());
		return page;
	}
	
	public CategoryFinancialSource save(CategoryFinancialSource financialSource) {
		return repoFinancialSources.save(financialSource);
	}
	
}
