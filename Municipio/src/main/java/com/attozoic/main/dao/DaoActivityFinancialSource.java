package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.repositories.RepositoryActivityFinancialSource;

@Repository
public class DaoActivityFinancialSource {

	@Autowired
	private RepositoryActivityFinancialSource repoActivityFinancialSources;
	
	public Page<ActivityFinancialSource> findAll() {
		Page<ActivityFinancialSource> page = new PageImpl<>(repoActivityFinancialSources.findAll());
		return page;
	}
	
	public ActivityFinancialSource save(ActivityFinancialSource financialSource) {
		return repoActivityFinancialSources.save(financialSource);
	}
	
}
