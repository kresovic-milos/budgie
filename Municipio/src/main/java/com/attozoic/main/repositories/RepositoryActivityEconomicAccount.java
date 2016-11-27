package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.balance.Balance;

@Repository
public interface RepositoryActivityEconomicAccount extends RepositoryEntity<ActivityEconomicAccount> {
	
	@Query("from Balance balance where balance.superEconomicAccount.uid=:activityEconomicAccountUid and balance.activeState = 0")
	public List<Balance> getActivityEconomicAccoutBalances(@Param("activityEconomicAccountUid") Long uid);
	
	//SELECT SUM(balances.balance_amount) as sumbalances FROM balances WHERE balances.year = 2016 AND balances.active_state = 0 AND balances.economic_account_uid = 2

//	@Query("SUM(balance.balance_amount) from Balance balance inner join ActivityEconomicAccount aea where balance.year = 2016 and balance.balanceType = 0 and balances.activeState = 0 and aea.activity.uid=:activityUid")
//	public double getSumBalances2016Budget(@Param("activityUid") Long activityUid);
	
	//@Query("sum(balance.balance_amount) from Balance balance inner join ActivityFinancialSource afs on balance.superEconomicAccount.uid=afs.uid where balance.superEconomicAccount.uid=:activityEconomicAccountUid balance.activeState = 0 and balance.balanceType=0 and balance.year=2016")
	//public double getBalance2016a(@Param("activityEconomicAccountUid") Long activityEconomicAccountUid, @Param("activityUid") Long activityUid);

	//@Query("sum(balance.balance_amount) as sum2016 from Balance balance inner join ActivityFinancialSource afs on balance.superEconomicAccount.uid=afs.uid where balance.balanceType=0 and balance.year=2016")
	//public double getBalance2016(@Param("activityEconomicAccountUid") Long activityEconomicAccountUid);
}
