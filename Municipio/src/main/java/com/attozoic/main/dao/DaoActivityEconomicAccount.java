package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.repositories.RepositoryActivityEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoActivityEconomicAccount extends DaoEntity {

	@Autowired
	private RepositoryActivityEconomicAccount repoActivityEconomicAccount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoActivityEconomicAccount;
	}
	
	public List<Object> getExpencesG() {
		return ((RepositoryActivityEconomicAccount)getRepoEntity()).getExpences2017B();
	}
	
	public List<SuperEconomicAccount> getAllExpences() {
		return ((RepositoryActivityEconomicAccount)getRepoEntity()).getAllExpences();
	}
	
	public double get411Sum() {
		return ((RepositoryActivityEconomicAccount)getRepoEntity()).get411Sum();
	}
	
	public double get412Sum() {
		return ((RepositoryActivityEconomicAccount)getRepoEntity()).get412Sum();
	}
	
}
