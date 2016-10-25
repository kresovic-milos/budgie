package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProject;

@Repository
public class DaoProject extends DaoEntity {

	@Autowired
	private RepositoryProject repo;
	
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	public ProjectFinancialSource addFinancialSource(Long uid, ProjectFinancialSource financialSource) {
		Project project = (Project) getRepoEntity().findOne(uid);
		project.getFinancialSources().add(financialSource);
		
		financialSource.getProject().add(project);			
		
		return (ProjectFinancialSource) getRepoEntity().save(financialSource);
	}

	public ProjectGoal addGoal(Long uid, ProjectGoal goal) {
		Project project = (Project) getRepoEntity().findOne(uid);
		goal.setProject(project);
		return (ProjectGoal) getRepoEntity().save(goal);
	}
	
}
