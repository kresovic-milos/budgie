package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProjectFinancialSource;

@Repository
public class DaoProjectFinancialSource extends DaoEntity {

	@Autowired
	private RepositoryProjectFinancialSource repo;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	@Override
	public SuperEntity update(SuperEntity superEntity) {
		ProjectFinancialSource projectFinancialSource = (ProjectFinancialSource) superEntity;
		projectFinancialSource.setSumSources123(projectFinancialSource.getSourceBaseYearPlus1() + projectFinancialSource.getSourceBaseYearPlus2() + projectFinancialSource.getSourceBaseYearPlus3());
		return super.update(projectFinancialSource);
	}
	
}
