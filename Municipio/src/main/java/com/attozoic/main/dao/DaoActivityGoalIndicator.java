package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.repositories.RepositoryActivityGoalIndicator;

@Repository
public class DaoActivityGoalIndicator {

	@Autowired
	private RepositoryActivityGoalIndicator repoActivityGoalIndicator;
	
	public Page<ActivityGoalIndicator> findAll() {
		Page<ActivityGoalIndicator> page = new PageImpl<>(repoActivityGoalIndicator.findAll());
		return page;
	}
	
	public ActivityGoalIndicator save(ActivityGoalIndicator activityGoalIndicator) {
		return repoActivityGoalIndicator.save(activityGoalIndicator);
	}

}
