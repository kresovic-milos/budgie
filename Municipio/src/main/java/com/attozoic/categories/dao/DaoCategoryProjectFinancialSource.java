package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryProjectFinancialSource;
import com.attozoic.categories.repositories.RepositoryCategoryProjectFinancialSource;

@Repository
public class DaoCategoryProjectFinancialSource {

	@Autowired
	private RepositoryCategoryProjectFinancialSource repoProjectFinancialSources;
	
	public Page<CategoryProjectFinancialSource> findAll() {
		Page<CategoryProjectFinancialSource> page = new PageImpl<>(repoProjectFinancialSources.findAll());
		return page;
	}
	
	public CategoryProjectFinancialSource save(CategoryProjectFinancialSource financialSource) {
		return repoProjectFinancialSources.save(financialSource);
	}
	
}