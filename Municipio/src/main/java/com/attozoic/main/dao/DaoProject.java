package com.attozoic.main.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.dto.DtoProjectEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProject;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProject extends DaoEntity {

	@Autowired
	private RepositoryProject repoProject;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProject;
	}
	
	public List<ProjectGoal> getProjectGoals(Long uid) {
		return repoProject.getProjectGoals(uid);
	}
	
	// getProjectFinancialSourceMap
	public Map<String, double[]> getProjectFinancialSourceMap(Long uid) {
		return repoProject.findOne(uid).generateProjectFinancialSourceMap();
	}
	
	// getProjectExpencesFooter
	public List<Double> getProjectExpencesFooter(Long uid) {
		return ((RepositoryProject)getRepoEntity()).getProjectExpencesFooter(uid);
	}
	
	// addProjectGoal
	@SuppressWarnings("unchecked")
	public ProjectGoal addGoal(Long uid, ProjectGoal goal) {
		Project project = (Project) getRepoEntity().findOne(uid);
		goal.setProject(project);
		return (ProjectGoal) getRepoEntity().save(goal);
	}
	
	// addProjectEconomicAccount
	@SuppressWarnings("unchecked")
	public ProjectEconomicAccount addProjectEconomicAccount(Long uid, ProjectEconomicAccount projectEconomicAccount) {
		Project project = (Project) getRepoEntity().findOne(uid);
		projectEconomicAccount.setProject(project);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
			projectEconomicAccount.generateBalances(numRebalances);
		return (ProjectEconomicAccount) getRepoEntity().save(projectEconomicAccount);
	}
	
	// List of Expences for Activity{uid}
	public List<DtoProjectEconomicAccount> getProjectExpencesList(Long uid) {
		List<DtoProjectEconomicAccount> list = new ArrayList<>();
		List<Object> objects = repoProject.getExpencesGroups(uid);
		List<SuperEconomicAccount> economicAccounts = repoProject.getProjectExpences(uid);
		for (Object o : objects) {
			ProjectEconomicAccount pea = new ProjectEconomicAccount();
			pea.setCode(o.toString().concat("000"));
			pea.generateBalances(getNumRebalances());
			List<ProjectEconomicAccount> list2 = new ArrayList<>();
			for (SuperEconomicAccount economicAccount : economicAccounts) {
				String threeDigit = ((ProjectEconomicAccount)economicAccount).getCode().substring(0, 3).concat("000");
				if (pea.getCode().equals(threeDigit)) {
					pea = pea.sumProjectEconomicAccounts((ProjectEconomicAccount)economicAccount);
					list2.add((ProjectEconomicAccount)economicAccount);
				}
			}
			Collections.sort(list2);
			DtoProjectEconomicAccount dto = new DtoProjectEconomicAccount(pea, list2); 
			list.add(dto);
		}
		Collections.sort(list);
		return list;
	}
	
	public int getNumRebalances() {
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		return numRebalances;
	}
	
}
