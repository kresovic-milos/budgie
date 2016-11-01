package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryHead;

@Repository
public class DaoHead extends DaoEntity {

	@Autowired
	private RepositoryHead repoHead;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoHead;
	}

}
