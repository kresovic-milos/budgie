package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProgramme;

@Repository
public class DaoProgramme extends DaoEntity {
	
	@Autowired
	private RepositoryProgramme repo;
	
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	
	
}
