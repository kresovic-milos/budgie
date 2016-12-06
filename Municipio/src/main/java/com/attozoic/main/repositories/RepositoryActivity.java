package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.SuperEconomicAccount;

@Repository
public interface RepositoryActivity extends RepositoryEntity<Activity> {
	
	@Query("from ActivityGoal goal where goal.activity.uid=:activityUid and goal.activeState = 0")
	public List<ActivityGoal> getActivityGoals(@Param("activityUid") Long uid);

	// ExpencesFooter
	@Query("select SUM(b.balance_amount) from Balance b inner join b.superEconomicAccount as aea where aea.activity.uid=:activityUid and aea.activeState = 0 and b.activeState = 0 group by b.year, b.balanceType")
	public List<Double> getActivityExpencesFooter(@Param("activityUid") Long activityUid);
	
	// GET ACTIVITY ECONOMIC ACCOUNTS
	@Query("FROM SuperEconomicAccount as aea WHERE aea.activity.uid=:activityUid AND aea.activeState = 0 ORDER BY aea.code")
	public List<SuperEconomicAccount> getActivityExpences(@Param("activityUid") Long uid);
	
	// GET ACTIVITY FINANCIAL SOURCES
	//@Query("FROM ActivityFinancialSource as afs WHERE afs.activity.uid=:activityUid AND afs.activeState = 0 ORDER BY afs.name")
	//public List<ActivityFinancialSource> getActivityFinances(@Param("activityUid") Long uid);
	
	// Expences ThreeDigits
	@Query("SELECT DISTINCT SUBSTRING(aea.code,1,3) FROM SuperEconomicAccount AS aea WHERE aea.activity.uid=:activityUid AND aea.activeState = 0")
	public List<Object> getExpencesGroups(@Param("activityUid") Long activityUid);
	
	// ===========================================================================================================================
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Activity a LEFT JOIN a.activityEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.activity.uid=:activityUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2016 AND b.balanceType=0 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getActivityFinances2016B(@Param("activityUid") Long activityUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Activity a LEFT JOIN a.activityEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.activity.uid=:activityUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2016 AND b.balanceType=1 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getActivityFinances2016O(@Param("activityUid") Long activityUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Activity a LEFT JOIN a.activityEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.activity.uid=:activityUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2017 AND b.balanceType=0 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getActivityFinances2017B(@Param("activityUid") Long activityUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Activity a LEFT JOIN a.activityEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.activity.uid=:activityUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2017 AND b.balanceType=1 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getActivityFinances2017O(@Param("activityUid") Long activityUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Activity a LEFT JOIN a.activityEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.activity.uid=:activityUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2018 AND b.balanceType=0 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getActivityFinances2018B(@Param("activityUid") Long activityUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Activity a LEFT JOIN a.activityEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.activity.uid=:activityUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2018 AND b.balanceType=1 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getActivityFinances2018O(@Param("activityUid") Long activityUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Activity a LEFT JOIN a.activityEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.activity.uid=:activityUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2019 AND b.balanceType=0 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getActivityFinances2019B(@Param("activityUid") Long activityUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Activity a LEFT JOIN a.activityEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.activity.uid=:activityUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2019 AND b.balanceType=1 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getActivityFinances2019O(@Param("activityUid") Long activityUid);
	
	// ===========================================================================================================================
	
	@Query("SELECT fs.name, b.year, b.balanceType, COALESCE(SUM(fs.amount), 0) FROM SuperFinancialSource AS fs RIGHT JOIN fs.balance AS b LEFT JOIN b.superEconomicAccount aea WHERE b.activeState=0 AND aea.activity.uid=:activityUid AND aea.activeState = 0 AND fs.activeState=0 GROUP BY fs.name, b.year, b.balanceType")
	public List<Object> getFinances(@Param("activityUid") Long activityUid);
	
	//@Query("SELECT fs.name, b.year, b.balanceType, COALESCE(SUM(fs.amount), 0) FROM SuperFinancialSource AS fs RIGHT JOIN fs.balance AS b LEFT JOIN b.superEconomicAccount aea WHERE b.activeState=0 AND aea.activity.uid=:activityUid AND aea.activeState = 0 AND fs.activeState=0 GROUP BY fs.name, b.year, b.balanceType")
	//public List<Object> getFinances(@Param("activityUid") Long activityUid);
	
}
