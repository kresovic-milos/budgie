package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.repositories.RepositoryProjectGoal;

@Repository
public class DaoProjectGoal {

	@Autowired
	private RepositoryProjectGoal repoProjectGoal;
	
	public Page<ProjectGoal> findAll() {
		Page<ProjectGoal> page = new PageImpl<>(repoProjectGoal.findAll());
		return page;
	}
	
	public ProjectGoal save(ProjectGoal projectGoal) {
		return repoProjectGoal.save(projectGoal);
	}

}
