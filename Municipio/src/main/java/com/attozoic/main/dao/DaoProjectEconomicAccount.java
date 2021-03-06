package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	public double get411Sum() {
		return ((RepositoryProjectEconomicAccount)getRepoEntity()).get411Sum();
	}
	
	public double get412Sum() {
		return ((RepositoryProjectEconomicAccount)getRepoEntity()).get412Sum();
	}
	
}
