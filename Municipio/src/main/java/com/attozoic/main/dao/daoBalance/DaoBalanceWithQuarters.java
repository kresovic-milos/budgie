package com.attozoic.main.dao.daoBalance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.repositories.repositoriesBalance.RepositoryBalanceWithQuarters;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoBalanceWithQuarters extends DaoEntity {

	@Autowired
	private RepositoryBalanceWithQuarters repoBalanceWithQuarters;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoBalanceWithQuarters;
	}
	
}
