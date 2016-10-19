package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.repositories.RepositoryActivityGoal;

@Repository
public class DaoActivityGoal {

	@Autowired
	private RepositoryActivityGoal repoActivityGoal;
	
	public Page<ActivityGoal> findAll() {
		Page<ActivityGoal> page = new PageImpl<>(repoActivityGoal.findAll());
		return page;
	}
	
	public ActivityGoal save(ActivityGoal activityGoal) {
		return repoActivityGoal.save(activityGoal);
	}

}
