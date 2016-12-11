package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.balance.Balance;

@Repository
public interface RepositoryActivityEconomicAccount extends RepositoryEntity<ActivityEconomicAccount> {
	
	@Query("from Balance balance where balance.superEconomicAccount.uid=:activityEconomicAccountUid and balance.activeState = 0")
	public List<Balance> getActivityEconomicAccoutBalances(@Param("activityEconomicAccountUid") Long uid);

	@Query("FROM SuperEconomicAccount AS s where s.activeState=0 ORDER BY s.code ASC")
	public List<SuperEconomicAccount> getAllExpences();
	
	// Ako ima rebalansa ovo nije dobro ============================================
	// Moze da se regulise u DaoAEA - ulazni parametar je ovde npr 2017.2 pa tamo if (2 rebalana ubaci 2017.2)
	@Query("SELECT DISTINCT SUBSTRING(aea.code,1,3), COALESCE(SUM(b.balance_amount), 0) FROM SuperEconomicAccount AS aea LEFT JOIN aea.balances AS b WHERE aea.activeState = 0 AND b.year=2017 AND b.balanceType=0 GROUP BY SUBSTRING(aea.code,1,3) ORDER BY aea.code ASC")
	public List<Object> getExpences2017B();
	
	@Query("SELECT DISTINCT SUBSTRING(aea.code,1,3), COALESCE(SUM(b.balance_amount), 0) FROM SuperEconomicAccount AS aea LEFT JOIN aea.balances AS b WHERE aea.activeState = 0 AND b.year=2017 AND b.balanceType=1 GROUP BY SUBSTRING(aea.code,1,3) ORDER BY aea.code ASC")
	public List<Object> getExpences2017O();
	
//	@Query("SELECT DISTINCT SUBSTRING(aea.code,1,3), "
//			+ "(COALESCE(SUM(b.balance_amount), 0) FROM Balance AS b WHERE b.superEconomicAccount.activeState=0 AND b.year=2017 AND b.balanceType=0 GROUP BY SUBSTRING(aea.code,1,3) ORDER BY aea.code ASC), "
//			+ "(COALESCE(SUM(b.balance_amount), 0) FROM Balance AS b WHERE b.superEconomicAccount.activeState=0 AND b.year=2017 AND b.balanceType=1 GROUP BY SUBSTRING(aea.code,1,3) ORDER BY aea.code ASC) GROP")
//	public List<Object> getExpences2017();
	
	// ==============================================================================
	
	@Query(value="SELECT COALESCE(SUM(sfs.amount), 0) AS total FROM ActivityEconomicAccount AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE SUBSTRING(aea.code,1,3)=411 AND aea.activeState=0 AND b.activeState=0 AND b.year=2017 AND b.balanceType=0 and sfs.activeState = 0")
	public double get411Sum();
	
	@Query(value="SELECT COALESCE(SUM(sfs.amount), 0) AS total FROM ActivityEconomicAccount AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE SUBSTRING(aea.code,1,3)=412 AND aea.activeState=0 AND b.activeState=0 AND b.year=2017 AND b.balanceType=0 and sfs.activeState = 0")
	public double get412Sum();
	
}
