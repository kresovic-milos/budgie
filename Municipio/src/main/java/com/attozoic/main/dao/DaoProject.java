package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.RebalanceOneField;
import com.attozoic.main.model.RebalanceTwoFields;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProject;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProject extends DaoEntity {

	@Autowired
	private RepositoryProject repoProject;
	
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
	
	// addProjectFinancialSource
	@SuppressWarnings("unchecked")
	public ProjectFinancialSource addProjectFinancialSource(Long uid, ProjectFinancialSource projectFinancialSource) {
		try {
			RebalancesCount rc = repoRebalanceCount.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceOneField> l = projectFinancialSource.getRebalances();
				for (int i = 0; i < numReb; i++) {
					l.add(new RebalanceOneField());
				}
				projectFinancialSource.setRebalances(l);
			}
		} catch(NullPointerException ex) {}
		Project project = (Project) getRepoEntity().findOne(uid);
		projectFinancialSource.setProject(project);		
		projectFinancialSource.setSumSources123(projectFinancialSource.getSourceBaseYearPlus1() + projectFinancialSource.getSourceBaseYearPlus2() + projectFinancialSource.getSourceBaseYearPlus3());
		getRepoEntity().save(project);
		return (ProjectFinancialSource) getRepoEntity().save(projectFinancialSource);
	}
	
	// addProjectEconomicAccount
	@SuppressWarnings("unchecked")
	public ProjectEconomicAccount addProjectEconomicAccount(Long uid, ProjectEconomicAccount projectEconomicAccount) {
		try {
			RebalancesCount rc = repoRebalanceCount.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceTwoFields> l = projectEconomicAccount.getRebalances();
				for (int i = 0; i < numReb; i++) {
					l.add(new RebalanceTwoFields());
				}
				projectEconomicAccount.setRebalances(l);
			}
		} catch(NullPointerException ex) {}
		Project project = (Project) getRepoEntity().findOne(uid);
		projectEconomicAccount.setProject(project);
		projectEconomicAccount.setSumExpenses123Budget(projectEconomicAccount.getExpenseBaseYearPlus1Budget1() + projectEconomicAccount.getExpenseBaseYearPlus1Budget2() + projectEconomicAccount.getExpenseBaseYearPlus1Budget3() + projectEconomicAccount.getExpenseBaseYearPlus1Budget4() + projectEconomicAccount.getExpenseBaseYearPlus2Budget() + projectEconomicAccount.getExpenseBaseYearPlus3Budget());
		projectEconomicAccount.setSumExpenses123Others(projectEconomicAccount.getExpenseBaseYearPlus1Others1() + projectEconomicAccount.getExpenseBaseYearPlus1Others2() + projectEconomicAccount.getExpenseBaseYearPlus1Others3() + projectEconomicAccount.getExpenseBaseYearPlus1Others4() + projectEconomicAccount.getExpenseBaseYearPlus2Others() + projectEconomicAccount.getExpenseBaseYearPlus3Others());
		projectEconomicAccount.setSumExpensesBaseYearPlus1Budget(projectEconomicAccount.getExpenseBaseYearPlus1Budget1() + projectEconomicAccount.getExpenseBaseYearPlus1Budget2() + projectEconomicAccount.getExpenseBaseYearPlus1Budget3() + projectEconomicAccount.getExpenseBaseYearPlus1Budget4());
		projectEconomicAccount.setSumExpensesBaseYearPlus1Others(projectEconomicAccount.getExpenseBaseYearPlus1Others1() + projectEconomicAccount.getExpenseBaseYearPlus1Others2() + projectEconomicAccount.getExpenseBaseYearPlus1Others3() + projectEconomicAccount.getExpenseBaseYearPlus1Others4());
		getRepoEntity().save(project);
		return (ProjectEconomicAccount) getRepoEntity().save(projectEconomicAccount);
	}
	
}
