package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.Authority;
import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.model.Function;
import com.attozoic.main.model.Head;
import com.attozoic.main.repositories.RepositoryActivity;
import com.attozoic.main.repositories.RepositoryEntity;

@Repository
public class DaoActivity extends DaoEntity {

	@Autowired
	private RepositoryActivity repo;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repo;
	}
	
	// addActivityGoal
	@SuppressWarnings("unchecked")
	public ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activityGoal.setActivity(activity);
		return (ActivityGoal) getRepoEntity().save(activityGoal);
	}
	
	// addActivityFinancialSource
	@SuppressWarnings("unchecked")
	public ActivityFinancialSource addActivityFinancialSource(Long uid, ActivityFinancialSource activityFinancialSource) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activityFinancialSource.getActivities().add(activity);
		activity.getActivityFinancialSources().add(activityFinancialSource);
		activityFinancialSource.setSumSources123(activityFinancialSource.getSourceBaseYearPlus1() + activityFinancialSource.getSourceBaseYearPlus2() + activityFinancialSource.getSourceBaseYearPlus3());
		return (ActivityFinancialSource) getRepoEntity().save(activityFinancialSource);
	}
	
	// addFunction
	@SuppressWarnings("unchecked")
	public Function addFunction(Long uid, Function function) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		function.getActivities().add(activity);
		//System.err.println(activity.getName());
		return (Function) getRepoEntity().save(function);
	}
	
	// addHead
	@SuppressWarnings("unchecked")
	public Head addHead(Long uid, Head head) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		head.getActivities().add(activity);
		return (Head) getRepoEntity().save(head);
	}
	
	// addAuthority
	@SuppressWarnings("unchecked")
	public Authority addAuthority(Long uid, Authority authority) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		authority.getActivities().add(activity);
		return (Authority) getRepoEntity().save(authority);
	}
	
	// addActivityEconomicAccount
	@SuppressWarnings("unchecked")
	public EconomicAccount addActivityEconomicAccount(Long uid, EconomicAccount ecAcc) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		ecAcc.getActivities().add(activity);
		activity.getActivityEconomicalAccounts().add(ecAcc);
		ecAcc.setSumExpenses123Budget(ecAcc.getExpenseBaseYearPlus1Budget1() + ecAcc.getExpenseBaseYearPlus1Budget2() + ecAcc.getExpenseBaseYearPlus1Budget3() + ecAcc.getExpenseBaseYearPlus1Budget4() + ecAcc.getExpenseBaseYearPlus2Budget() + ecAcc.getExpenseBaseYearPlus3Budget());
		ecAcc.setSumExpenses123Others(ecAcc.getExpenseBaseYearPlus1Others1() + ecAcc.getExpenseBaseYearPlus1Others2() + ecAcc.getExpenseBaseYearPlus1Others3() + ecAcc.getExpenseBaseYearPlus1Others4() + ecAcc.getExpenseBaseYearPlus2Others() + ecAcc.getExpenseBaseYearPlus3Others());
		ecAcc.setSumExpensesBaseYearPlus1Budget(ecAcc.getExpenseBaseYearPlus1Budget1() + ecAcc.getExpenseBaseYearPlus1Budget2() + ecAcc.getExpenseBaseYearPlus1Budget3() + ecAcc.getExpenseBaseYearPlus1Budget4());
		ecAcc.setSumExpensesBaseYearPlus1Others(ecAcc.getExpenseBaseYearPlus1Others1() + ecAcc.getExpenseBaseYearPlus1Others2() + ecAcc.getExpenseBaseYearPlus1Others3() + ecAcc.getExpenseBaseYearPlus1Others4());
		return (EconomicAccount) getRepoEntity().save(ecAcc);
	}
	
}
