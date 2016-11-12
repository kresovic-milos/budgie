package com.attozoic.main.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProjectEconomicAccount;

@Repository
public class DaoProjectEconomicAccount extends DaoEntity {

	@Autowired
	private RepositoryProjectEconomicAccount repoProjectEconomicAccount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProjectEconomicAccount;
	}
	
	@Override
	public SuperEntity update(SuperEntity superEntity) {
		ProjectEconomicAccount projectEconomicAccount = (ProjectEconomicAccount) superEntity;
		projectEconomicAccount.setSumExpenses123Budget(projectEconomicAccount.sumExpenses123Budget());
		projectEconomicAccount.setSumExpenses123Others(projectEconomicAccount.sumExpenses123Others());
		return super.update(projectEconomicAccount);
	}
	

	
}
