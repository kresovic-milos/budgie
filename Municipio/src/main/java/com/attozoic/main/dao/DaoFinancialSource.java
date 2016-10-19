package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.FinancialSource;
import com.attozoic.main.repositories.RepositoryFinancialSource;

@Repository
public class DaoFinancialSource {

	@Autowired
	private RepositoryFinancialSource repoFinancialSources;
	
	public Page<FinancialSource> findAll() {
		Page<FinancialSource> page = new PageImpl<>(repoFinancialSources.findAll());
		return page;
	}
	
	public FinancialSource save(FinancialSource financialSource) {
		return repoFinancialSources.save(financialSource);
	}
	
}
