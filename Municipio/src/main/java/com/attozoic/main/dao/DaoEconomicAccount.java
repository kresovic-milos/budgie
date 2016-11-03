package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.repositories.RepositoryEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoEconomicAccount extends DaoEntity {

	@Autowired
	private RepositoryEconomicAccount repoEconomicAccount;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoEconomicAccount;
	}
	
}
