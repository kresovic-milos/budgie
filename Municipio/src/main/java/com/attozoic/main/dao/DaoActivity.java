package com.attozoic.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.dto.DtoActivityEconomicAccountThreeDigitsCollection;
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
	
	public List<DtoActivityEconomicAccountThreeDigitsCollection> getDto(Long uid) {
		Activity activity = (Activity)getRepoEntity().findOne(uid);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		return activity.generateThreeDigitsActivityEconomicAccountsDTOList(numRebalances);
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
	
//	public Map<String, List<ActivityEconomicAccount>> getActivityEconomicAccountMap(Long uid) {
//		Map<String, List<ActivityEconomicAccount>> activityEconomicAccountMap = new HashMap<>();
//		Activity activity = (Activity)getRepoEntity().findOne(uid);
//		List<ActivityEconomicAccount> activityEconomicAccountList = activity.getActivityEconomicAccounts();
//		for (ActivityEconomicAccount activityEconomicAccount : activityEconomicAccountList) {
//			String threeDigits = activityEconomicAccount.getCode().substring(0, 3).concat("000");
//			if (activityEconomicAccountMap.containsKey(threeDigits)) {
//				List<ActivityEconomicAccount> newActivityEconomicAccountList = activityEconomicAccountMap.get(threeDigits);
//				newActivityEconomicAccountList.add(activityEconomicAccount);
//				activityEconomicAccountMap.put(threeDigits, newActivityEconomicAccountList);
//			} else {
//				List<ActivityEconomicAccount> newActivityEconomicAccountList = new ArrayList<>();
//				newActivityEconomicAccountList.add(activityEconomicAccount);
//				activityEconomicAccountMap.put(threeDigits, newActivityEconomicAccountList);
//			}
//		}
//		return activityEconomicAccountMap;
//	}
	
//	public List<ActivityEconomicAccount> getActivityEconomicAccountList(Long uid) {
//		List<ActivityEconomicAccount> activityEconomicAccountList = new ArrayList<>();
//		Map<String, List<ActivityEconomicAccount>> activityEconomicAccountMap = getActivityEconomicAccountMap(uid);
//		for (Map.Entry<String, List<ActivityEconomicAccount>> entry : activityEconomicAccountMap.entrySet()) {
//		    
//			ActivityEconomicAccount activityEconomicAccount = new ActivityEconomicAccount();
//		    for (ActivityEconomicAccount activityEconomicAccount2 : entry.getValue()) {
//				activityEconomicAccount.sumActivityEconomicAccounts(activityEconomicAccount2);
//			}
//		    activityEconomicAccount.setCode(entry.getKey());
//			activityEconomicAccountList.add(activityEconomicAccount);
//			for (ActivityEconomicAccount activityEconomicAccount2 : entry.getValue()) {
//				activityEconomicAccountList.add(activityEconomicAccount2);
//			}
//		    
//		}
//		return activityEconomicAccountList;
//	}

	
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
