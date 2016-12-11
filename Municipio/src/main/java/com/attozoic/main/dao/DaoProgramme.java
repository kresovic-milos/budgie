package com.attozoic.main.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.Programme;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.model.dto.DtoProgrammeEconomicAccount;
import com.attozoic.main.model.dto.DtoProgrammeFinances;
import com.attozoic.main.model.dto.DtoSuperEA;
import com.attozoic.main.repositories.RepositoryActivityEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProgramme;
import com.attozoic.main.repositories.RepositoryRebalancesCount;
import com.attozoic.main.repositories.repositoriesBalance.RepositoryBalance;

@Repository
public class DaoProgramme extends DaoEntity {
	
	@Autowired
	private RepositoryProgramme repoProgramme;
	
	@Autowired
	private DaoActivity daoActivity;
	
	@Autowired
	private DaoProject daoProject;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@Autowired
	private RepositoryBalance repoBalance;
	
	@Autowired
	private RepositoryActivityEconomicAccount repoActivityEcAcc;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoProgramme;
	}
	
	// EKONOMSKA KLASIFIKACIJA ===============================================
	public List<DtoSuperEA> getThreeDigitsList() {
		List<DtoSuperEA> list = new ArrayList<>();
		for (Object o1 : repoActivityEcAcc.getExpences2017B()) {
			Object[] arr1 = (Object[])o1;
			for (Object o2 : repoActivityEcAcc.getExpences2017O()) {
				Object[] arr2 = (Object[])o2;
				if (((String)arr1[0]).equals((String)arr2[0])) {
					List<Double> balances = new ArrayList<>();
					balances.add((Double)arr1[1]);
					balances.add((Double)arr2[1]);
					DtoSuperEA dto = new DtoSuperEA("", (String)arr1[0], balances);
					list.add(dto);
				}
			}
		}
		return list;
	}
	
	// ========================================================================
	
	// ALL PROGRAMMES CHART
	public List<Object> getChart(double year) {
		List<Object> activities = repoProgramme.getChart(year);
		List<Object> projects = repoProgramme.getChartP(year);
		List<Object> list = new ArrayList<>();
		for(int i = 0; i < activities.size(); i++) {
			Object[] a = new Object[2]; 
			a = (Object[])activities.get(i);
			Object[] niz = new Object[2]; 
			double sum = (double)a[1];
			for(int j = 0; j < projects.size(); j++) {
				Object[] p = new Object[2]; 
				p = (Object[])projects.get(j);
				if (a[0].equals(p[0])) {
					sum += (double)p[1];
				}
			}
			niz[0] = (String)a[0];
			niz[1] = sum;
			list.add(niz);
		}
		return list;
	}
	
	public List<ProgrammeGoal> getProgrammeGoals(Long uid) {
		return repoProgramme.getProgrammeGoals(uid);
	}

// ==============================================================================================================================
	//GENERATE BALANCES AMOUNTS - Za potrebe UPDATE-ovanja balanasa nakon sto nisu valjali
	public void generateBalancesAmounts(Long uid) {
		Programme programme = (Programme)repoProgramme.findOne(uid);
		List<Activity> activities = programme.getActivities();
		for (Activity activity : activities) {
			if (activity.getActiveState() == ActiveState.ACTIVE) {
				List<ActivityEconomicAccount> activityEconomicAccounts = activity.getActivityEconomicAccounts();
				for (ActivityEconomicAccount activityEconomicAccount : activityEconomicAccounts) {
					if (activityEconomicAccount.getActiveState() == ActiveState.ACTIVE) {
						List<Balance> balances = activityEconomicAccount.getBalances();
						for (Balance balance : balances) {
							balance.generateBalanceAmount();
							repoBalance.save(balance);
						}
					}
				}
			}
		}
	}
//	==============================================================================================================================
	
	// getProgrammeFinancialSourceFooter
//	public DtoProgrammeFinances getProgrammeFinancialSourceFooter(Long uid) {
//		Map<String, double[]> map = getProgrammeFinancialSourceMap(uid);
//		DtoProgrammeFinances dto = new DtoProgrammeFinances();
//		dto.setName(repoProgramme.findOne(uid).getName());
//		double[] values = new double[8];
//		for (Map.Entry<String, double[]> entry : map.entrySet()) {
//			for (int i = 0; i < entry.getValue().length; i++) {
//				values[i] += entry.getValue()[i];
//			}
//		}
//		dto.setAmounts(values);
//		return dto;
//		//return repoProgramme.findOne(uid).generateProgrammeFinancialSourceFooter();
//	}
	
	// getProgrammeFinances and FOOTER
	public DtoProgrammeFinances getProgrammeFinances(Long uid) {
		Map<String, double[]> map = new HashMap<>();
		List<Activity> activities = repoProgramme.getActiveActivities(uid);
		for (Activity activity : activities) {
			Map<String, double[]> activitiesMap = daoActivity.getActivityFinancialSourceMap(activity.getUid());
			for (Map.Entry<String, double[]> entry : activitiesMap.entrySet()) {
				if (map.containsKey(entry.getKey())) {
					double[] niz = map.get(entry.getKey());
					double[] niz1 = entry.getValue();
					for (int i = 0; i < niz.length; i++) {
						niz[i] += niz1[i];
					}
					map.put(entry.getKey(), niz);
				} else {
					map.put(entry.getKey(), entry.getValue());
				}
			}
		}
		List<Project> projects = repoProgramme.getActiveProjects(uid);
		for (Project project : projects) {
			Map<String, double[]> projectsMap = daoProject.getProjectFinancialSourceMap(project.getUid());
			for (Map.Entry<String, double[]> entry : projectsMap.entrySet()) {
				if (map.containsKey(entry.getKey())) {
					double[] niz = map.get(entry.getKey());
					double[] niz1 = entry.getValue();
					for (int i = 0; i < niz.length; i++) {
						niz[i] += niz1[i];
					}
					map.put(entry.getKey(), niz);
				} else {
					map.put(entry.getKey(), entry.getValue());
				}
			}
		}
		DtoProgrammeFinances programmeFinances = new DtoProgrammeFinances();
		double[] values = new double[8];
		for (Map.Entry<String, double[]> entry : map.entrySet()) {
			for (int i = 0; i < entry.getValue().length; i++) {
				values[i] += entry.getValue()[i];
			}
		}
		programmeFinances.setName(repoProgramme.findOne(uid).getName());
		programmeFinances.setAmounts(values);
		List<Map.Entry<String, double[]>> entries = new ArrayList<Map.Entry<String, double[]>>(map.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<String, double[]>>() {
			public int compare(Map.Entry<String, double[]> entry1, Map.Entry<String, double[]> entry2) {
				return (entry1.getKey().substring(0, 2)).compareTo(entry2.getKey().substring(0, 2));
			}
		});
		programmeFinances.setList(entries);
		return programmeFinances;
	}
//	==============================================================================================================================
	
	// getProgrammeEconomicAccountFooter
	public DtoProgrammeEconomicAccount getProgrammeEconomicAccountFooter(Long uid) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		return programme.generateProgrammeEconomicAccountFooter(numRebalances);
	}
	
	// getProgrammeEconomicAccountDTOsList
	public List<DtoProgrammeEconomicAccount> getProgrammeEconomicAccountList(Long uid) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		return programme.generateProgrammeEconomicAccountList(numRebalances);
	}
	
	@SuppressWarnings("unchecked")
	public ProgrammeGoal addProgrammeGoal(Long uid, ProgrammeGoal programmeGoal) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		programmeGoal.setProgramme(programme);
		return (ProgrammeGoal) getRepoEntity().save(programmeGoal);
	}
	
//	==============================================================================================================================
	
	@SuppressWarnings("unchecked")
	public Activity addActivity(Long uid, Activity activity) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		activity.setProgramme(programme);
		activity.setAnex("(Анекс 3 Упутства за израду програмског буџета- релевантно само за Републику Србију)");
		return (Activity) getRepoEntity().save(activity);
	}
	
	@SuppressWarnings("unchecked")
	public Project addProject(Long uid, Project project) {
		Programme programme = (Programme) getRepoEntity().findOne(uid);
		project.setProgramme(programme);
		project.setCode(programme.getCode() + "-(П1, П2, П3...)");
		project.setIsCapital("(статус пројектно техничке документације, постоји или не постоји, статус имовинско правних односа, решени или нерешени)");
		project.setIsIpa("(бира се ИПА година финансирања и ИПА програм/мере из предефинисане листе коју у базу уноси Министарство финансија)");
		project.setAnex("(Анекс 3 Упутства за израду програмског буџета- релевантно само за Републику Србију)");
		return (Project) getRepoEntity().save(project);
	}
	
}
