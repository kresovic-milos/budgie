package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Authority;
import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.model.Function;
import com.attozoic.main.model.Head;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProject;

@Repository
public class DaoProject extends DaoEntity {

	@Autowired
	private RepositoryProject repo;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	@SuppressWarnings("unchecked")
	public ProjectFinancialSource addFinancialSource(Long uid, ProjectFinancialSource financialSource) {
		Project project = (Project) getRepoEntity().findOne(uid);
		project.getFinancialSources().add(financialSource);
		financialSource.getProject().add(project);			
		return (ProjectFinancialSource) getRepoEntity().save(financialSource);
	}

	@SuppressWarnings("unchecked")
	public ProjectGoal addGoal(Long uid, ProjectGoal goal) {
		Project project = (Project) getRepoEntity().findOne(uid);
		goal.setProject(project);
		return (ProjectGoal) getRepoEntity().save(goal);
	}
	
	@SuppressWarnings("unchecked")
	public Function addFunction(Long uid, Function function) {
		Project project = (Project) getRepoEntity().findOne(uid);
		function.getProjects().add(project);
		return (Function) getRepoEntity().save(function);
	}
	
	@SuppressWarnings("unchecked")
	public Head addHead(Long uid, Head head) {
		Project project = (Project) getRepoEntity().findOne(uid);
		head.getProjects().add(project);
		return (Head) getRepoEntity().save(head);
	}
	
	@SuppressWarnings("unchecked")
	public Authority addAuthority(Long uid, Authority authority) {
		Project project = (Project) getRepoEntity().findOne(uid);
		authority.getProjects().add(project);
		return (Authority) getRepoEntity().save(authority);
	}
	
	@SuppressWarnings("unchecked")
	public EconomicAccount addProjectEconomicAccount(Long uid, EconomicAccount economicAccount) {
		Project project = (Project) getRepoEntity().findOne(uid);
		economicAccount.getProjects().add(project);
		project.getProjectEconomicalAccounts().add(economicAccount);
		return (EconomicAccount) getRepoEntity().save(economicAccount);
	}
	
}
