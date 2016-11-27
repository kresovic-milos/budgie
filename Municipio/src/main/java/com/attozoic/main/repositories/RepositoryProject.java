package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectGoal;

@Repository
public interface RepositoryProject extends RepositoryEntity<Project> {
	
	@Query("from ProjectGoal goal where goal.project.uid=:projectUid and goal.activeState = 0")
	public List<ProjectGoal> getProjectGoals(@Param("projectUid") Long uid);
	
	@Query("from ProjectEconomicAccount ecAcc where ecAcc.project.uid=:projectUid and ecAcc.activeState = 0")
	public List<ProjectEconomicAccount> getProjectExpences(@Param("projectUid") Long uid);
	
	@Query("select SUM(b.balance_amount) from Balance b inner join b.superEconomicAccount as aea where aea.project.uid=:projectUid and b.activeState = 0 group by b.year, b.balanceType")
	public List<Double> getProjectExpencesFooter(@Param("projectUid") Long activityUid);
	
}
