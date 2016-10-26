package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryFunction;

@Repository
public class DaoFunction extends DaoEntity {
	
	@Autowired
	private RepositoryFunction repoFunction;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoFunction;
	}
	
}
