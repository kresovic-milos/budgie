package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Authority;
import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.model.Function;
import com.attozoic.main.model.Head;
import com.attozoic.main.model.Project;
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
	private RepositoryProject repo;
	
	@Autowired
	private RepositoryRebalancesCount repoReb;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	@SuppressWarnings("unchecked")
	public ProjectFinancialSource addFinancialSource(Long uid, ProjectFinancialSource financialSource) {
		try {
			RebalancesCount rc = repoReb.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceOneField> l = financialSource.getRebalances();
				for (int i = 0; i < numReb; i++) {
					l.add(new RebalanceOneField());
				}
				financialSource.setRebalances(l);
			}
		} catch(NullPointerException ex) {}
		Project project = (Project) getRepoEntity().findOne(uid);
		project.getFinancialSources().add(financialSource);
		financialSource.getProject().add(project);		
		financialSource.setSumSources123(financialSource.getSourceBaseYearPlus1() + financialSource.getSourceBaseYearPlus2() + financialSource.getSourceBaseYearPlus3());
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
	public EconomicAccount addProjectEconomicAccount(Long uid, EconomicAccount ecAcc) {
		try {
			RebalancesCount rc = repoReb.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceTwoFields> l = ecAcc.getRebalances();
				for (int i = 0; i < numReb; i++) {
					l.add(new RebalanceTwoFields());
				}
				ecAcc.setRebalances(l);
			}
		} catch(NullPointerException ex) {}
		Project project = (Project) getRepoEntity().findOne(uid);
		ecAcc.getProjects().add(project);
		project.getProjectEconomicalAccounts().add(ecAcc);
		ecAcc.setSumExpenses123Budget(ecAcc.getExpenseBaseYearPlus1Budget1() + ecAcc.getExpenseBaseYearPlus1Budget2() + ecAcc.getExpenseBaseYearPlus1Budget3() + ecAcc.getExpenseBaseYearPlus1Budget4() + ecAcc.getExpenseBaseYearPlus2Budget() + ecAcc.getExpenseBaseYearPlus3Budget());
		ecAcc.setSumExpenses123Others(ecAcc.getExpenseBaseYearPlus1Others1() + ecAcc.getExpenseBaseYearPlus1Others2() + ecAcc.getExpenseBaseYearPlus1Others3() + ecAcc.getExpenseBaseYearPlus1Others4() + ecAcc.getExpenseBaseYearPlus2Others() + ecAcc.getExpenseBaseYearPlus3Others());
		ecAcc.setSumExpensesBaseYearPlus1Budget(ecAcc.getExpenseBaseYearPlus1Budget1() + ecAcc.getExpenseBaseYearPlus1Budget2() + ecAcc.getExpenseBaseYearPlus1Budget3() + ecAcc.getExpenseBaseYearPlus1Budget4());
		ecAcc.setSumExpensesBaseYearPlus1Others(ecAcc.getExpenseBaseYearPlus1Others1() + ecAcc.getExpenseBaseYearPlus1Others2() + ecAcc.getExpenseBaseYearPlus1Others3() + ecAcc.getExpenseBaseYearPlus1Others4());
		return (EconomicAccount) getRepoEntity().save(ecAcc);
	}
	
}
