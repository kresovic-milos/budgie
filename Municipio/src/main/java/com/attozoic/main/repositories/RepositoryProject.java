package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.SuperEconomicAccount;

@Repository
public interface RepositoryProject extends RepositoryEntity<Project> {
	
	@Query("from ProjectGoal goal where goal.project.uid=:projectUid and goal.activeState = 0")
	public List<ProjectGoal> getProjectGoals(@Param("projectUid") Long uid);
	
	// ExpencesFooter
	@Query("select SUM(b.balance_amount) from Balance b inner join b.superEconomicAccount as aea where aea.project.uid=:projectUid and aea.activeState = 0 and b.activeState = 0 group by b.year, b.balanceType")
	public List<Double> getProjectExpencesFooter(@Param("projectUid") Long projectUid);
	
	// Expences
	@Query("FROM SuperEconomicAccount as aea WHERE aea.project.uid=:projectUid AND aea.activeState = 0 ORDER BY aea.code")
	public List<SuperEconomicAccount> getProjectExpences(@Param("projectUid") Long projectUid);
	
	// Expences ThreeDigits
	@Query("SELECT DISTINCT SUBSTRING(aea.code,1,3) FROM SuperEconomicAccount AS aea WHERE aea.project.uid=:projectUid AND aea.activeState = 0")
	public List<Object> getExpencesGroups(@Param("projectUid") Long projectUid);
	
	
	
}
