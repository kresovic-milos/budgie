package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.repositories.RepositoryAuthority;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoAuthority extends DaoEntity {

	@Autowired
	private RepositoryAuthority repoAuthority;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoAuthority;
	}
	
	public List<Activity> findActivitiesByUid(Long uid) {
		return repoAuthority.findOne(uid).getActivities();
	}
	
}
