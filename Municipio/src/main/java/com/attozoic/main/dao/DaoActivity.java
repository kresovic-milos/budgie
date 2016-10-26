package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.EconomicAccount;
import com.attozoic.main.model.Function;
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

	@SuppressWarnings("unchecked")
	public ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activityGoal.setActivity(activity);
		return (ActivityGoal) getRepoEntity().save(activityGoal);
	}
	
	@SuppressWarnings("unchecked")
	public ActivityFinancialSource addActivityFinancialSource(Long uid, ActivityFinancialSource activityFinancialSource) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activityFinancialSource.getActivities().add(activity);
		activity.getActivityFinancialSources().add(activityFinancialSource);
		return (ActivityFinancialSource) getRepoEntity().save(activityFinancialSource);
	}
	
	@SuppressWarnings("unchecked")
	public Function addFunction(Long uid, Function function) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		function.getActivities().add(activity);
		//System.err.println(activity.getName());
		return (Function) getRepoEntity().save(function);
	}
	
	@SuppressWarnings("unchecked")
	public EconomicAccount addActivityEconomicAccount(Long uid, EconomicAccount economicAccount) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		economicAccount.getActivities().add(activity);
		activity.getActivityEconomicalAccount().add(economicAccount);
		return (EconomicAccount) getRepoEntity().save(economicAccount);
	}
	
}
