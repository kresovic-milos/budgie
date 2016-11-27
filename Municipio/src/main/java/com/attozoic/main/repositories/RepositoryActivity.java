package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;

@Repository
public interface RepositoryActivity extends RepositoryEntity<Activity> {
	
	@Query("from ActivityEconomicAccount ecAcc where ecAcc.activity.uid=:activityUid and ecAcc.activeState = 0")
	public List<ActivityEconomicAccount> getActivityExpences(@Param("activityUid") Long uid);
	
//	@Query("select SUM(balance.balance_amount) from Balance balance left join ActivityEconomicAccount aea on balance.superEconomicAccount.uid = aea.uid where balance.year = 2016 and balance.balanceType = 0 and balances.activeState = 0 and aea.activity.uid=:activityUid")
//	public double getSumBalances2016Budget(@Param("activityUid") Long activityUid);
}
