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

}
