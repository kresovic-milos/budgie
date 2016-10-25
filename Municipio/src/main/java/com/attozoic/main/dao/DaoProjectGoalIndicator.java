package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProjectGoalIndicator;

@Repository
public class DaoProjectGoalIndicator extends DaoEntity {

	@Autowired
	private RepositoryProjectGoalIndicator repo;
	
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}

}
