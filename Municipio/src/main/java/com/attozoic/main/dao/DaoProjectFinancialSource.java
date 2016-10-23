package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.repositories.RepositoryProjectFinancialSource;

@Repository
public class DaoProjectFinancialSource {

	@Autowired
	private RepositoryProjectFinancialSource repoProjectFinancialSources;
	
	public Page<ProjectFinancialSource> findAll() {
		Page<ProjectFinancialSource> page = new PageImpl<>(repoProjectFinancialSources.findAll());
		return page;
	}
	
	public ProjectFinancialSource save(ProjectFinancialSource financialSource) {
		return repoProjectFinancialSources.save(financialSource);
	}
	
}
