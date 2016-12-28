package com.attozoic.main.dao;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.model.dto.DtoProjectEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProject;
import com.attozoic.main.repositories.RepositoryProjectFinancialSource;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoProject extends DaoEntity {

	@Autowired
	private RepositoryProject repoProject;
	
	@Autowired
	private RepositoryProjectFinancialSource repoProjectFinancialSource;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProject;
	}
	
	public List<Project> getProjectsByAuthority(String authorityCode) {
		return ((RepositoryProject)getRepoEntity()).getProjectsByAuthority(authorityCode);
	}
	
	public void updateAll() {
		List<Project> projects = ((RepositoryProject)getRepoEntity()).findAll();
		for (Project project : projects) {
			project.setCode(project.getProgramme().getCode() + "-(П1, П2, П3...)");
			project.setIsCapital("(статус пројектно техничке документације, постоји или не постоји, статус имовинско правних односа, решени или нерешени)");
			project.setIsIpa("(бира се ИПА година финансирања и ИПА програм/мере из предефинисане листе коју у базу уноси Министарство финансија)");
			project.setAnex("(Анекс 3 Упутства за израду програмског буџета- релевантно само за Републику Србију)");
			((RepositoryProject)getRepoEntity()).save(project);
		}
	}
	
	public List<SuperEconomicAccount> getProjectExpences(Long uid) {
		return ((RepositoryProject)getRepoEntity()).getProjectExpences(uid);
	}
	
//	public List<SuperFinancialSource> getProjectFinances(Long uid) {
//		return ((RepositoryProject)getRepoEntity()).getProjectFinances(uid);
//	}
	
	public List<ProjectGoal> getProjectGoals(Long uid) {
		return repoProject.getProjectGoals(uid);
	}
	
	// getProjectFinancialSourceMap
//	public Map<String, double[]> getProjectFinancialSourceMap(Long uid) {
//		return repoProject.findOne(uid).generateProjectFinancialSourceMap();
//	}
	// getActivityFinancialSourceMap
	public Map<String, double[]> getProjectFinancialSourceMap(Long uid) {
		Map<String, double[]> map = new HashMap<>();
		List<Object> list1 = repoProject.getProjectFinances2016B(uid);
		List<Object> list2 = repoProject.getProjectFinances2016O(uid);
		List<Object> list3 = repoProject.getProjectFinances2017B(uid);
		List<Object> list4 = repoProject.getProjectFinances2017O(uid);
		List<Object> list5 = repoProject.getProjectFinances2018B(uid);
		List<Object> list6 = repoProject.getProjectFinances2018O(uid);
		List<Object> list7 = repoProject.getProjectFinances2019B(uid);
		List<Object> list8 = repoProject.getProjectFinances2019O(uid);
		for (Object o : list1) {
			Object[] objects = new Object[2];
			objects = (Object[])o; // Objekat pretvoren u niz od 2 clana [String, double]
			String s = (String)objects[0];
			
			if (map.containsKey(s)) {
				double[] values = map.get(s);
				values[0] = (double)objects[1];
				map.put(s, values);
			} else {
				double[] values = new double[8];
				values[0] = (double)objects[1];
				map.put(s, values);
			}
		}
		for (Object o : list2) {
			Object[] objects = new Object[2];
			objects = (Object[])o; // Objekat pretvoren u niz od 2 clana [String, double]
			String s = (String)objects[0];
			
			if (map.containsKey(s)) {
				double[] values = map.get(s);
				values[1] = (double)objects[1];
				map.put(s, values);
			} else {
				double[] values = new double[8];
				values[1] = (double)objects[1];
				map.put(s, values);
			}
		}
		for (Object o : list3) {
			Object[] objects = new Object[2];
			objects = (Object[])o; // Objekat pretvoren u niz od 2 clana [String, double]
			String s = (String)objects[0];
			
			if (map.containsKey(s)) {
				double[] values = map.get(s);
				values[2] = (double)objects[1];
				map.put(s, values);
			} else {
				double[] values = new double[8];
				values[2] = (double)objects[1];
				map.put(s, values);
			}
		}
		for (Object o : list4) {
			Object[] objects = new Object[2];
			objects = (Object[])o; // Objekat pretvoren u niz od 2 clana [String, double]
			String s = (String)objects[0];
			
			if (map.containsKey(s)) {
				double[] values = map.get(s);
				values[3] = (double)objects[1];
				map.put(s, values);
			} else {
				double[] values = new double[8];
				values[3] = (double)objects[1];
				map.put(s, values);
			}
		}
		for (Object o : list5) {
			Object[] objects = new Object[2];
			objects = (Object[])o; // Objekat pretvoren u niz od 2 clana [String, double]
			String s = (String)objects[0];
			
			if (map.containsKey(s)) {
				double[] values = map.get(s);
				values[4] = (double)objects[1];
				map.put(s, values);
			} else {
				double[] values = new double[8];
				values[4] = (double)objects[1];
				map.put(s, values);
			}
		}
		for (Object o : list6) {
			Object[] objects = new Object[2];
			objects = (Object[])o; // Objekat pretvoren u niz od 2 clana [String, double]
			String s = (String)objects[0];
			
			if (map.containsKey(s)) {
				double[] values = map.get(s);
				values[5] = (double)objects[1];
				map.put(s, values);
			} else {
				double[] values = new double[8];
				values[5] = (double)objects[1];
				map.put(s, values);
			}
		}
		for (Object o : list7) {
			Object[] objects = new Object[2];
			objects = (Object[])o; // Objekat pretvoren u niz od 2 clana [String, double]
			String s = (String)objects[0];
			
			if (map.containsKey(s)) {
				double[] values = map.get(s);
				values[6] = (double)objects[1];
				map.put(s, values);
			} else {
				double[] values = new double[8];
				values[6] = (double)objects[1];
				map.put(s, values);
			}
		}
		for (Object o : list8) {
			Object[] objects = new Object[2];
			objects = (Object[])o; // Objekat pretvoren u niz od 2 clana [String, double]
			String s = (String)objects[0];
			
			if (map.containsKey(s)) {
				double[] values = map.get(s);
				values[7] = (double)objects[1];
				map.put(s, values);
			} else {
				double[] values = new double[8];
				values[7] = (double)objects[1];
				map.put(s, values);
			}
		}
		return map;
		//return repoActivity.findOne(uid).generateActivityFinancialSourceMap();
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
				List<Balance> balances = economicAccount.getBalances();
				Collections.sort(balances);
				Balance b = balances.get(balances.size()-6);
				List<ProjectFinancialSource> finSrcs = repoProjectFinancialSource.getFinancialSources(b.getUid()); 
				StringBuilder sb = new StringBuilder();
				for (ProjectFinancialSource fs : finSrcs) {
					if (fs.getActiveState()==ActiveState.ACTIVE) {
						String code = fs.getCode();
						long amount = (long)fs.getAmount(); 
						sb.append(code);
						sb.append("-");
						sb.append(String.valueOf(NumberFormat.getInstance().format(amount)));
						sb.append(" ");
					}
				}
				economicAccount.setFinSrcs(sb.toString());
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
	
	 ///////// MATRIX ////////////


	public List<ProjectEconomicAccount> getProjectExpencesGroups(Long uid) {
		List<ProjectEconomicAccount> list = new ArrayList<>();
		List<Object> objects = repoProject.getExpencesGroups(uid);
		List<SuperEconomicAccount> economicAccounts = repoProject.getProjectExpences(uid);
		for (Object o : objects) {
			ProjectEconomicAccount pea = new ProjectEconomicAccount();
			pea.setCode(o.toString());
			pea.generateBalances(getNumRebalances());
			//List<ProjectEconomicAccount> list2 = new ArrayList<>();
			for (SuperEconomicAccount economicAccount : economicAccounts) {
			String threeDigit = ((ProjectEconomicAccount)economicAccount).getCode().substring(0, 3);
				if (pea.getCode().equals(threeDigit)) {
				pea = pea.sumProjectEconomicAccounts((ProjectEconomicAccount)economicAccount);
				//list2.add((ProjectEconomicAccount)economicAccount);
				}
			}	
		list.add(pea);
		}
		Collections.sort(list);
		return list;
	}
	
}
