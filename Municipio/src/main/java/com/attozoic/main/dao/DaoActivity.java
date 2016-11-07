package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.RebalanceOneField;
import com.attozoic.main.model.RebalanceTwoFields;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.repositories.RepositoryActivity;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoActivity extends DaoEntity {

	@Autowired
	private RepositoryActivity repoActivity;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoActivity;
	}
	
	// addActivityGoal
	@SuppressWarnings("unchecked")
	public ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activityGoal.setActivity(activity);
		getRepoEntity().save(activity);
		return (ActivityGoal) getRepoEntity().save(activityGoal);
	}
	
	// addActivityFinancialSource
	@SuppressWarnings("unchecked")
	public ActivityFinancialSource addActivityFinancialSource(Long uid, ActivityFinancialSource activityFinancialSource) {
		try {
			RebalancesCount rc = repoRebalanceCount.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceOneField> l = activityFinancialSource.getRebalances();
				for (int i = 0; i < numReb; i++) {
					l.add(new RebalanceOneField());
				}
				activityFinancialSource.setRebalances(l);
			}
		} catch (NullPointerException ex) {}
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activityFinancialSource.setActivity(activity);
		activityFinancialSource.setSumSources123(activityFinancialSource.getSourceBaseYearPlus1() + activityFinancialSource.getSourceBaseYearPlus2() + activityFinancialSource.getSourceBaseYearPlus3());
		getRepoEntity().save(activity);
		return (ActivityFinancialSource) getRepoEntity().save(activityFinancialSource);
	}
	
	// addFunction
	@SuppressWarnings("unchecked")
	public Function addFunction(Long uid, Function function) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activity.setFunction(function);
		function.getActivities().add(activity);
		return (Function) getRepoEntity().save(function);
	}
	
	// addHead
	@SuppressWarnings("unchecked")
	public Head addHead(Long uid, Head head) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activity.setHead(head);
		head.getActivities().add(activity);
		return (Head) getRepoEntity().save(head);
	}
	
	// addAuthority
	@SuppressWarnings("unchecked")
	public Authority addAuthority(Long uid, Authority authority) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activity.setAuthority(authority);
		authority.getActivities().add(activity);
		return (Authority) getRepoEntity().save(authority);
	}
	
	// addActivityEconomicAccount
	@SuppressWarnings("unchecked")
	public ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount) {
		try {
			RebalancesCount rc = repoRebalanceCount.findOne(new Long(1));
			int numReb = rc.getRebalancesCount();
			if (numReb > 0) {
				List<RebalanceTwoFields> l = activityEconomicAccount.getRebalances();
				for (int i = 0; i < numReb; i++) {
					l.add(new RebalanceTwoFields());
				}
				activityEconomicAccount.setRebalances(l);
			}
		} catch (NullPointerException ex) {}
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activityEconomicAccount.setActivity(activity);
		activityEconomicAccount.setSumExpenses123Budget(activityEconomicAccount.getExpenseBaseYearPlus1Budget1() + activityEconomicAccount.getExpenseBaseYearPlus1Budget2() + activityEconomicAccount.getExpenseBaseYearPlus1Budget3() + activityEconomicAccount.getExpenseBaseYearPlus1Budget4() + activityEconomicAccount.getExpenseBaseYearPlus2Budget() + activityEconomicAccount.getExpenseBaseYearPlus3Budget());
		activityEconomicAccount.setSumExpenses123Others(activityEconomicAccount.getExpenseBaseYearPlus1Others1() + activityEconomicAccount.getExpenseBaseYearPlus1Others2() + activityEconomicAccount.getExpenseBaseYearPlus1Others3() + activityEconomicAccount.getExpenseBaseYearPlus1Others4() + activityEconomicAccount.getExpenseBaseYearPlus2Others() + activityEconomicAccount.getExpenseBaseYearPlus3Others());
		activityEconomicAccount.setSumExpensesBaseYearPlus1Budget(activityEconomicAccount.getExpenseBaseYearPlus1Budget1() + activityEconomicAccount.getExpenseBaseYearPlus1Budget2() + activityEconomicAccount.getExpenseBaseYearPlus1Budget3() + activityEconomicAccount.getExpenseBaseYearPlus1Budget4());
		activityEconomicAccount.setSumExpensesBaseYearPlus1Others(activityEconomicAccount.getExpenseBaseYearPlus1Others1() + activityEconomicAccount.getExpenseBaseYearPlus1Others2() + activityEconomicAccount.getExpenseBaseYearPlus1Others3() + activityEconomicAccount.getExpenseBaseYearPlus1Others4());
		getRepoEntity().save(activity);
		return (ActivityEconomicAccount) getRepoEntity().save(activityEconomicAccount);
	}
	
}
