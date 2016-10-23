package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.repositories.RepositoryProjectGoalIndicator;

@Repository
public class DaoProjectGoalIndicator {

	@Autowired
	private RepositoryProjectGoalIndicator repoProjectGoalIndicator;
	
	public Page<ProjectGoalIndicator> findAll() {
		Page<ProjectGoalIndicator> page = new PageImpl<>(repoProjectGoalIndicator.findAll());
		return page;
	}
	
	public ProjectGoalIndicator save(ProjectGoalIndicator projectGoalIndicator) {
		return repoProjectGoalIndicator.save(projectGoalIndicator);
	}

}
