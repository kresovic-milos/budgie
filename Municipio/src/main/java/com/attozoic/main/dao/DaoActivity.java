package com.attozoic.main.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.dto.DtoActivityEconomicAccount;
import com.attozoic.main.model.dto.DtoFinanceFooter;
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
	
	public List<ActivityGoal> getActivityGoals(Long uid) {
		return repoActivity.getActivityGoals(uid);
	}
	
	// getActivityFinancialSourceFooter()
	public DtoFinanceFooter getActivityFinancialSourceFooter(Long uid) {
		return repoActivity.findOne(uid).generateActivityFinancialSourceFooter();
	}
	
	// getActivityFinancialSourceMap
	public Map<String, double[]> getActivityFinancialSourceMap(Long uid) {
		return repoActivity.findOne(uid).generateActivityFinancialSourceMap();
	}
	
	// getActivityExpencesFooter
	public List<Double> getActivityExpencesFooter(Long uid) {
		return ((RepositoryActivity)getRepoEntity()).getActivityExpencesFooter(uid);
	}
	
	// getActivityEconomicAccountFooter
//	public SuperEconomicAccount getActivityEconomicAccountFooter(Long uid) {
//		Activity activity = (Activity)getRepoEntity().findOne(uid);
//		int numRebalances = 0;
//		try {
//			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
//		} catch (NullPointerException ex) {}
//		return activity.generateActivityEconomicAccountFooter(numRebalances);
//	}
	
	// getActivityEconomicAccountDTOsList
	public List<DtoActivityEconomicAccount> getActivityEconomicAccountsList(Long uid) {
		Activity activity = (Activity)getRepoEntity().findOne(uid);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		return activity.generateActivityEconomicAccountsList(numRebalances);
	}
	
	// addActivityGoal
	@SuppressWarnings("unchecked")
	public ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activityGoal.setActivity(activity);
		return (ActivityGoal) getRepoEntity().save(activityGoal);
	}
	
	// addActivityEconomicAccount
	@SuppressWarnings("unchecked")
	public ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activityEconomicAccount.setActivity(activity);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
			activityEconomicAccount.generateBalances(numRebalances);
		return (ActivityEconomicAccount) getRepoEntity().save(activityEconomicAccount);
	}
	
}
