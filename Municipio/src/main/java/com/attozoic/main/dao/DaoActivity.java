package com.attozoic.main.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.repositories.RepositoryActivity;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoActivity extends DaoEntity {

	@Autowired
	private RepositoryActivity repoActivity;
	
	@SuppressWarnings("unused")
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
		return (ActivityGoal) getRepoEntity().save(activityGoal);
	}
	
	// addActivityEconomicAccount
	@SuppressWarnings("unchecked")
	public ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount) {

		//		List<BalanceContainer> balanceContainers = activityEconomicAccount.getBalanceContainers();
//		int numRebalances = 0;
//		try {
//			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
//		} catch (NullPointerException ex) {}
//		for (int i = 0; i < (balanceContainers.size() + numRebalances); i++) {
//			balanceContainers.add(new BalanceContainer());
//		}
		
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activityEconomicAccount.setActivity(activity);
		return (ActivityEconomicAccount) getRepoEntity().save(activityEconomicAccount);
	}
	
	public Map<ActivityEconomicAccount, List<ActivityEconomicAccount>> getActivityEconomicAccountMap(Long uid) {
		Map<ActivityEconomicAccount, List<ActivityEconomicAccount>> activityEconomicAccountMap = new HashMap<>();
		Activity activity = (Activity)getRepoEntity().findOne(uid);
		List<ActivityEconomicAccount> activityEconomicAccountList = activity.getActivityEconomicAccounts();
		for (ActivityEconomicAccount activityEconomicAccount : activityEconomicAccountList) {
			String threeDigits = activityEconomicAccount.getCode().substring(0, 2).concat("000");
//			ActivityEconomicAccount oldKey = new ActivityEconomicAccount();
//			oldKey.setCode(threeDigits);
			if (containsCode(activityEconomicAccountMap, threeDigits)) {
				ActivityEconomicAccount key = getSearchedKey(activityEconomicAccountMap, threeDigits);
				activityEconomicAccountMap.get(key).add(activityEconomicAccount);
				ActivityEconomicAccount newKey = new ActivityEconomicAccount();
				List<ActivityEconomicAccount> newList = activityEconomicAccountMap.get(key);
				for (ActivityEconomicAccount activityEconomicAccount2 : newList) {
					newKey.sumActivityEconomicAccounts(activityEconomicAccount2);
				}
				activityEconomicAccountMap.remove(key);
				activityEconomicAccountMap.put(newKey, newList);
			} else {
				List<ActivityEconomicAccount> newList = new ArrayList<>();
				newList.add(activityEconomicAccount);
				ActivityEconomicAccount newKey = activityEconomicAccount;
				newKey.setCode(threeDigits);
				activityEconomicAccountMap.put(newKey, newList);
			}
		}
		return null;
	}
	
	private boolean containsCode(Map<ActivityEconomicAccount, List<ActivityEconomicAccount>> map, String code) {
		boolean contains = false;
		for (ActivityEconomicAccount activityEconomicAccount : map.keySet()) {
			if (activityEconomicAccount.getCode().equals(code)) {
				contains = true;
			}
		}
		return contains;
	}

	private ActivityEconomicAccount getSearchedKey(Map<ActivityEconomicAccount, List<ActivityEconomicAccount>> map, String code) {
		for (ActivityEconomicAccount activityEconomicAccount : map.keySet()) {
			if (activityEconomicAccount.getCode().equals(code)) {
				return activityEconomicAccount;
			}
		}
		return null;
	}

	
	// buildActivityDTO
//	public DtoProgrammeExpencesItem buildActivityDto(Long uid) {
//		return repoActivity.findOne(uid).buildDtoActivityExpences();
//	}
	
	// buildActivityFinanceDTO
//	public DtoProgrammeFinancialSource buildActivityFinanceDto(Long uid, int num) {
//		return repoActivity.findOne(uid).buildActivityFinanceDto(num);
//	}
	
	// addActivityFinancialSource
//	@SuppressWarnings("unchecked")
//	public ActivityFinancialSource addActivityFinancialSource(Long uid, ActivityFinancialSource activityFinancialSource) {
//		try {
//			RebalancesCount rc = repoRebalanceCount.findOne(new Long(1));
//			int numReb = rc.getRebalancesCount();
//			if (numReb > 0) {
//				List<RebalanceOneField> l = activityFinancialSource.getRebalances();
//				for (int i = 0; i < numReb; i++) {
//					l.add(new RebalanceOneField());
//				}
//				activityFinancialSource.setRebalances(l);
//			}
//		} catch (NullPointerException ex) {}
//		Activity activity = (Activity) getRepoEntity().findOne(uid);
//		activityFinancialSource.setActivity(activity);
//		activityFinancialSource.setSumSources123(activityFinancialSource.getSourceBaseYearPlus1() + activityFinancialSource.getSourceBaseYearPlus2() + activityFinancialSource.getSourceBaseYearPlus3());
//		getRepoEntity().save(activity);
//		return (ActivityFinancialSource) getRepoEntity().save(activityFinancialSource);
//	}
	
}
