package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.repositories.RepositoryActivity;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoActivity extends DaoEntity {

	@Autowired
	private RepositoryActivity repo;
	
	@Override
	public RepositoryEntity<Activity> getRepoEntity() {
		return repo;
	}
}
