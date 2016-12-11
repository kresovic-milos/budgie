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
	
	@Query("from Project p where p.authorityCode=:authorityCode and p.activeState = 0 order by p.programme.uid asc, p.headCode asc")
	public List<Project> getProjectsByAuthority(@Param("authorityCode") String authorityCode);
	
	@Query("from ProjectGoal goal where goal.project.uid=:projectUid and goal.activeState = 0")
	public List<ProjectGoal> getProjectGoals(@Param("projectUid") Long uid);
	
	// ExpencesFooter
	@Query("select SUM(b.balance_amount) from Balance b inner join b.superEconomicAccount as aea where aea.project.uid=:projectUid and aea.activeState = 0 and b.activeState = 0 group by b.year, b.balanceType")
	public List<Double> getProjectExpencesFooter(@Param("projectUid") Long projectUid);
	
	// GET PROJECT ECONOMIC ACCOUNTS
	@Query("FROM SuperEconomicAccount as aea WHERE aea.project.uid=:projectUid AND aea.activeState = 0 ORDER BY aea.code")
	public List<SuperEconomicAccount> getProjectExpences(@Param("projectUid") Long projectUid);
	
	// GET PROJECT FINANCIAL SOURCES
	//@Query("FROM SuperFinancialSource as sfs WHERE sfs.project.uid=:projectUid AND sfs.activeState = 0 ORDER BY sfs.name")
	//public List<SuperFinancialSource> getProjectFinances(@Param("projectUid") Long uid);
	
	// Expences ThreeDigits
	@Query("SELECT DISTINCT SUBSTRING(aea.code,1,3) FROM SuperEconomicAccount AS aea WHERE aea.project.uid=:projectUid AND aea.activeState = 0")
	public List<Object> getExpencesGroups(@Param("projectUid") Long projectUid);
	
	// ===========================================================================================================================
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Project a LEFT JOIN a.projectEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.project.uid=:projectUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2016 AND b.balanceType=0 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getProjectFinances2016B(@Param("projectUid") Long projectUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Project a LEFT JOIN a.projectEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.project.uid=:projectUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2016 AND b.balanceType=1 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getProjectFinances2016O(@Param("projectUid") Long projectUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Project a LEFT JOIN a.projectEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.project.uid=:projectUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2017 AND b.balanceType=0 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getProjectFinances2017B(@Param("projectUid") Long projectUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Project a LEFT JOIN a.projectEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.project.uid=:projectUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2017 AND b.balanceType=1 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getProjectFinances2017O(@Param("projectUid") Long projectUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Project a LEFT JOIN a.projectEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.project.uid=:projectUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2018 AND b.balanceType=0 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getProjectFinances2018B(@Param("projectUid") Long projectUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Project a LEFT JOIN a.projectEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.project.uid=:projectUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2018 AND b.balanceType=1 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getProjectFinances2018O(@Param("projectUid") Long projectUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Project a LEFT JOIN a.projectEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.project.uid=:projectUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2019 AND b.balanceType=0 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getProjectFinances2019B(@Param("projectUid") Long projectUid);
	
	@Query(value="SELECT sfs.name, COALESCE(SUM(sfs.amount), 0) AS total FROM Project a LEFT JOIN a.projectEconomicAccounts AS aea LEFT JOIN aea.balances AS b LEFT JOIN b.financialSources AS sfs WHERE aea.project.uid=:projectUid AND aea.activeState=0 AND b.activeState=0 AND b.year=2019 AND b.balanceType=1 and sfs.activeState = 0 GROUP BY sfs.name")
	public List<Object> getProjectFinances2019O(@Param("projectUid") Long projectUid);
	
	// ===========================================================================================================================
	
	
}
