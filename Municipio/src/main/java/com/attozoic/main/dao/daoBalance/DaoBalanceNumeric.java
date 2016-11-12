package com.attozoic.main.dao.daoBalance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.repositories.repositoriesBalance.RepositoryBalanceNumeric;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoBalanceNumeric extends DaoEntity {

	@Autowired
	private RepositoryBalanceNumeric repoBalanceNumeric;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoBalanceNumeric;
	}
	
}
