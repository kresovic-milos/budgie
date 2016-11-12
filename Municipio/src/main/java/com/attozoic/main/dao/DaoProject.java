package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProject;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProject extends DaoEntity {

	@Autowired
	private RepositoryProject repoProject;
	
	@SuppressWarnings("unused")
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProject;
	}
	
	// addProjectGoal
	@SuppressWarnings("unchecked")
	public ProjectGoal addGoal(Long uid, ProjectGoal goal) {
		Project project = (Project) getRepoEntity().findOne(uid);
		goal.setProject(project);
		getRepoEntity().save(project);
		return (ProjectGoal) getRepoEntity().save(goal);
	}
	
	// addProjectEconomicAccount
	@SuppressWarnings("unchecked")
	public ProjectEconomicAccount addProjectEconomicAccount(Long uid, ProjectEconomicAccount projectEconomicAccount) {

//		List<BalanceContainer> balanceContainers = projectEconomicAccount.getBalanceContainers();
//		int numContainers = 4;
//		try {
//			int numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
//			numContainers += (numRebalances);
//		} catch (NullPointerException ex) {}
//		for (int i = 0; i < numContainers; i++) {
//			balanceContainers.add(new BalanceContainer());
//		}
		
		Project project = (Project) getRepoEntity().findOne(uid);
		projectEconomicAccount.setProject(project);
		return (ProjectEconomicAccount) getRepoEntity().save(projectEconomicAccount);
	}
	
	// buildProjectDTO
//	public DtoProgrammeExpencesItem buildProjectDto(Long uid) {
//		return repoProject.findOne(uid).buildDtoProjectExpences();
//	}
	
	// buildProjectFinanceDTO
//	public DtoProgrammeFinancialSource buildProjectFinanceDto(Long uid, int num) {
//		return repoProject.findOne(uid).buildProjectFinanceDto(num);
//	}
	
	// addProjectFinancialSource
//	@SuppressWarnings("unchecked")
//	public ProjectFinancialSource addProjectFinancialSource(Long uid, ProjectFinancialSource projectFinancialSource) {
//		try {
//			RebalancesCount rc = repoRebalanceCount.findOne(new Long(1));
//			int numReb = rc.getRebalancesCount();
//			if (numReb > 0) {
//				List<RebalanceOneField> l = projectFinancialSource.getRebalances();
//				for (int i = 0; i < numReb; i++) {
//					l.add(new RebalanceOneField());
//				}
//				projectFinancialSource.setRebalances(l);
//			}
//		} catch(NullPointerException ex) {}
//		Project project = (Project) getRepoEntity().findOne(uid);
//		projectFinancialSource.setProject(project);		
//		projectFinancialSource.setSumSources123(projectFinancialSource.getSourceBaseYearPlus1() + projectFinancialSource.getSourceBaseYearPlus2() + projectFinancialSource.getSourceBaseYearPlus3());
//		getRepoEntity().save(project);
//		return (ProjectFinancialSource) getRepoEntity().save(projectFinancialSource);
//	}
	
}
