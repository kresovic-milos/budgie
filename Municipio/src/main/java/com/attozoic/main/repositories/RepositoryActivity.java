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
	
	// Expences
	@Query("FROM SuperEconomicAccount as aea WHERE aea.activity.uid=:activityUid AND aea.activeState = 0 ORDER BY aea.code")
	public List<SuperEconomicAccount> getActivityExpences(@Param("activityUid") Long uid);
	
	// Expences ThreeDigits
	@Query("SELECT DISTINCT SUBSTRING(aea.code,1,3) FROM SuperEconomicAccount AS aea WHERE aea.activity.uid=:activityUid AND aea.activeState = 0")
	public List<Object> getExpencesGroups(@Param("activityUid") Long activityUid);
	
}
