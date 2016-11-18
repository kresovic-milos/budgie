package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.balance.BalanceText;
import com.attozoic.main.repositories.RepositoryActivityGoalIndicator;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoActivityGoalIndicator extends DaoEntity {

	@Autowired
	private RepositoryActivityGoalIndicator repoActivityGoalIndicator;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoActivityGoalIndicator;
	}
	
}
