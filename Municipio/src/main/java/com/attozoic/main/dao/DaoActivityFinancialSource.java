package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.repositories.RepositoryActivityFinancialSource;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoActivityFinancialSource extends DaoEntity {

	@Autowired
	private RepositoryActivityFinancialSource repo;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	@Override
	public SuperEntity update(SuperEntity superEntity) {
		ActivityFinancialSource activityFinancialSource = (ActivityFinancialSource) superEntity;
		activityFinancialSource.setSumSources123(activityFinancialSource.getSourceBaseYearPlus1() + activityFinancialSource.getSourceBaseYearPlus2() + activityFinancialSource.getSourceBaseYearPlus3());
		return super.update(activityFinancialSource);
	}
	
}
