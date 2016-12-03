package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.Programme;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;

@Repository
public interface RepositoryProgramme extends RepositoryEntity<Programme> {
	
	@Query("from ProgrammeGoal goal where goal.programme.uid=:programmeUid and goal.activeState = 0")
	public List<ProgrammeGoal> getProgrammeGoals(@Param("programmeUid") Long uid);
	
	@Query("from Activity a where a.activeState = 0 and a.programme.uid=:programmeUid")
	public List<Activity> getActiveActivities(@Param("programmeUid") Long programmeUid);
	
	@Query("from Project p where p.activeState = 0 and p.programme.uid=:programmeUid")
	public List<Project> getActiveProjects(@Param("programmeUid") Long programmeUid);
	
	@Query(value="SELECT p.name, COALESCE(SUM(b.balance_amount), 0) AS total FROM Programme p LEFT JOIN p.activities AS a LEFT JOIN a.activityEconomicAccounts AS aea LEFT JOIN aea.balances AS b WHERE aea.activeState=0 AND b.activeState=0 AND b.year=:year AND b.balanceType=0 GROUP BY p.name ORDER BY p.uid")
	public List<Object> getChart(@Param("year") double year);
	
	@Query(value="SELECT p.name, COALESCE(SUM(b.balance_amount), 0) AS total FROM Programme p LEFT JOIN p.projects AS a LEFT JOIN a.projectEconomicAccounts AS aea LEFT JOIN aea.balances AS b WHERE aea.activeState=0 AND b.activeState=0 AND b.year=:year AND b.balanceType=0 GROUP BY p.name ORDER BY p.uid")
	public List<Object> getChartP(@Param("year") double year);
	
}
