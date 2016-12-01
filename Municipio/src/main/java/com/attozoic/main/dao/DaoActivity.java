package com.attozoic.main.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.dto.DtoActivityEconomicAccount;
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
	
	// getActivityFinancialSourceMap
	public Map<String, double[]> getActivityFinancialSourceMap(Long uid) {
		return repoActivity.findOne(uid).generateActivityFinancialSourceMap();
	}
	
	// getActivityExpencesFooter AND ActivityFinancesFooter
	public List<Double> getActivityExpencesFooter(Long uid) {
		return ((RepositoryActivity)getRepoEntity()).getActivityExpencesFooter(uid);
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
	
	// List of Expences for Activity{uid}
	public List<DtoActivityEconomicAccount> getActivityExpencesList(Long uid) {
		List<DtoActivityEconomicAccount> list = new ArrayList<>();
		List<Object> objects = repoActivity.getExpencesGroups(uid);
		List<SuperEconomicAccount> economicAccounts = repoActivity.getActivityExpences(uid);
		for (Object o : objects) {
			ActivityEconomicAccount aea = new ActivityEconomicAccount();
			aea.setCode(o.toString().concat("000"));
			aea.generateBalances(getNumRebalances());
			List<ActivityEconomicAccount> list2 = new ArrayList<>();
			for (SuperEconomicAccount economicAccount : economicAccounts) {
				String threeDigit = ((ActivityEconomicAccount)economicAccount).getCode().substring(0, 3).concat("000");
				if (aea.getCode().equals(threeDigit)) {
					aea = aea.sumActivityEconomicAccounts((ActivityEconomicAccount)economicAccount);
					list2.add((ActivityEconomicAccount)economicAccount);
				}
			}
			Collections.sort(list2);
			DtoActivityEconomicAccount dto = new DtoActivityEconomicAccount(aea, list2); 
			list.add(dto);
		}
		Collections.sort(list);
		return list;
	}
	
	public int getNumRebalances() {
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		return numRebalances;
	}
		
}
