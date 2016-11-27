package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoal;

@Repository
public interface RepositoryActivity extends RepositoryEntity<Activity> {
	
	@Query("from ActivityGoal goal where goal.activity.uid=:activityUid and goal.activeState = 0")
	public List<ActivityGoal> getActivityGoals(@Param("activityUid") Long uid);
	
	@Query("from ActivityEconomicAccount ecAcc where ecAcc.activity.uid=:activityUid and ecAcc.activeState = 0")
	public List<ActivityEconomicAccount> getActivityExpences(@Param("activityUid") Long uid);
	
	@Query("select SUM(b.balance_amount) from Balance b inner join b.superEconomicAccount as aea where aea.activity.uid=:activityUid and b.activeState = 0 group by b.year, b.balanceType")
	public List<Double> getActivityExpencesFooter(@Param("activityUid") Long activityUid);
	
}
