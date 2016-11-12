package com.attozoic.main.dao.daoBalance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.repositories.repositoriesBalance.RepositoryBalanceContainer;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoBalanceContainer extends DaoEntity {

	@Autowired
	private RepositoryBalanceContainer repoBalanceContainer;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoBalanceContainer;
	}
	
}
