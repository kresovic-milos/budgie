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
import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.model.dto.DtoActivityEconomicAccount;
import com.attozoic.main.repositories.RepositoryActivity;
import com.attozoic.main.repositories.RepositoryActivityFinancialSource;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryRebalancesCount;

@Repository
public class DaoActivity extends DaoEntity {

	@Autowired
	private RepositoryActivity repoActivity;
	
	@Autowired
	private RepositoryActivityFinancialSource repoActivityFinancialSource;
	
	@Autowired
	private RepositoryRebalancesCount repoRebalanceCount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoActivity;
	}
	
	public List<Activity> getActivitiesByAuthority(String authorityCode) {
		return ((RepositoryActivity)getRepoEntity()).getActivitiesByAuthority(authorityCode);
	}
	
	public List<SuperEconomicAccount> getActivityExpences(Long uid) {
		return ((RepositoryActivity)getRepoEntity()).getActivityExpences(uid);
	}
	
//	public List<ActivityFinancialSource> getActivityFinances(Long uid) {
//		return ((RepositoryActivity)getRepoEntity()).getActivityFinances(uid);
//	}
	
//	public List<Object> getActivityFinancesB(Long uid) {
//		return repoActivity.getActivityFinancesB(uid);
//	}
//	
//	public List<Object> getActivityFinancesO(Long uid) {
//		return repoActivity.getActivityFinancesO(uid);
//	}
	
	public List<ActivityGoal> getActivityGoals(Long uid) {
		return repoActivity.getActivityGoals(uid);
	}
	
	//
	// getActivityFinancialSourceMap
	public List<Object> getActivityFinancial(Long uid) {
		return repoActivity.getFinances(uid);
	}
	
	// getActivityFinancialSourceMap
	public Map<String, double[]> getActivityFinancialSourceMap(Long uid) {
		Map<String, double[]> map = new HashMap<>();
		List<Object> list1 = repoActivity.getActivityFinances2016B(uid);
		List<Object> list2 = repoActivity.getActivityFinances2016O(uid);
		List<Object> list3 = repoActivity.getActivityFinances2017B(uid);
		List<Object> list4 = repoActivity.getActivityFinances2017O(uid);
		List<Object> list5 = repoActivity.getActivityFinances2018B(uid);
		List<Object> list6 = repoActivity.getActivityFinances2018O(uid);
		List<Object> list7 = repoActivity.getActivityFinances2019B(uid);
		List<Object> list8 = repoActivity.getActivityFinances2019O(uid);
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
//		List<Map.Entry<String, double[]>> entries = new ArrayList<Map.Entry<String, double[]>>(map.entrySet());
//		Collections.sort(entries, new Comparator<Map.Entry<String, double[]>>() {
//			public int compare(Map.Entry<String, double[]> entry1, Map.Entry<String, double[]> entry2) {
//				return (entry1.getKey().substring(0, 2)).compareTo(entry2.getKey().substring(0, 2));
//			}
//		});
		return map;
		//return repoActivity.findOne(uid).generateActivityFinancialSourceMap();
	}
	
	// getActivityExpencesFooter AND ActivityFinancesFooter
	public List<Double> getActivityExpencesFooter(Long uid) {
		return ((RepositoryActivity)getRepoEntity()).getActivityExpencesFooter(uid);
	}
	
	// addActivityGoal
	@SuppressWarnings("unchecked")
	public ActivityGoal addActivityGoal(Long uid, ActivityGoal activityGoal) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activityGoal.setActivity(activity);
		return (ActivityGoal) getRepoEntity().save(activityGoal);
	}
	
	// addActivityEconomicAccount
	@SuppressWarnings("unchecked")
	public ActivityEconomicAccount addActivityEconomicAccount(Long uid, ActivityEconomicAccount activityEconomicAccount) {
		Activity activity = (Activity) getRepoEntity().findOne(uid);
		activityEconomicAccount.setActivity(activity);
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
			activityEconomicAccount.generateBalances(numRebalances);
		return (ActivityEconomicAccount) getRepoEntity().save(activityEconomicAccount);
	}
	
	// List of Expences for Activity{uid}
	public List<DtoActivityEconomicAccount> getActivityExpencesList(Long uid) {
		System.out.println("srda");
		List<DtoActivityEconomicAccount> list = new ArrayList<>();
		List<Object> objects = repoActivity.getExpencesGroups(uid);
		List<SuperEconomicAccount> economicAccounts = repoActivity.getActivityExpences(uid);
		for (Object o : objects) {
			ActivityEconomicAccount aea = new ActivityEconomicAccount();
			aea.setCode(o.toString().concat("000"));
			aea.generateBalances(getNumRebalances());
			List<ActivityEconomicAccount> list2 = new ArrayList<>();
			for (SuperEconomicAccount economicAccount : economicAccounts) {
				List<Balance> balances = economicAccount.getBalances();
				Collections.sort(balances);
				Balance b = balances.get(balances.size()-6);
				List<ActivityFinancialSource> finSrcs = repoActivityFinancialSource.getFinancialSources(b.getUid()); 
				StringBuilder sb = new StringBuilder();
				for (ActivityFinancialSource fs : finSrcs) {
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
				String threeDigit = ((ActivityEconomicAccount)economicAccount).getCode().substring(0, 3).concat("000");
				if (aea.getCode().equals(threeDigit)) {
					aea = aea.sumActivityEconomicAccounts((ActivityEconomicAccount)economicAccount);
					list2.add((ActivityEconomicAccount)economicAccount);
				}
			}
			Collections.sort(list2);
			DtoActivityEconomicAccount dto = new DtoActivityEconomicAccount(aea, list2); 
			list.add(dto);
		}
		Collections.sort(list);
		return list;
	}
	
//	public List<DtoActivityEconomicAccount> getActivityExpencesList(Long uid) {
//		List<DtoActivityEconomicAccount> list = new ArrayList<>();
//		List<ThreeDigitEconomicAccount> threeDigits = repoThreeDigitEconomicAccount.getThreeDigitEconomicAccounts(uid);
//		//List<Object> objects = repoActivity.getExpencesGroups(uid);
//		List<SuperEconomicAccount> economicAccounts = repoActivity.getActivityExpences(uid);
//		for (ThreeDigitEconomicAccount o : threeDigits) {
//			ActivityEconomicAccount aea = new ActivityEconomicAccount();
//			//aea.setCode(o.toString().concat("000"));
//			aea.generateBalances(getNumRebalances());
//			aea.setCode(o.getCode());
//			aea.setPoz(o.getPoz());
//			List<ActivityEconomicAccount> list2 = new ArrayList<>();
//			for (SuperEconomicAccount economicAccount : economicAccounts) {
//				String threeDigit = ((ActivityEconomicAccount)economicAccount).getCode().substring(0, 3).concat("000");
//				if (aea.getCode().concat("000").equals(threeDigit)) {
//					aea = aea.sumActivityEconomicAccounts((ActivityEconomicAccount)economicAccount);
//					list2.add((ActivityEconomicAccount)economicAccount);
//				}
//			}
//			Collections.sort(list2);
//			DtoActivityEconomicAccount dto = new DtoActivityEconomicAccount(aea, list2); 
//			list.add(dto);
//		}
//		Collections.sort(list);
//		return list;
//	}
	
	public int getNumRebalances() {
		int numRebalances = 0;
		try {
			numRebalances = repoRebalanceCount.findOne(new Long(1)).getRebalancesCount();
		} catch (NullPointerException ex) {}
		return numRebalances;
	}
	
	///////// MATRIX ////////////
	
	public List<ActivityEconomicAccount> getActivityExpencesGroups(Long uid) {
		List<ActivityEconomicAccount> list = new ArrayList<>();
		List<Object> objects = repoActivity.getExpencesGroups(uid);
		List<SuperEconomicAccount> economicAccounts = repoActivity.getActivityExpences(uid);
		for (Object o : objects) {
			ActivityEconomicAccount aea = new ActivityEconomicAccount();
			aea.setCode(o.toString());
			aea.generateBalances(getNumRebalances());
			//List<ActivityEconomicAccount> list2 = new ArrayList<>();
			for (SuperEconomicAccount economicAccount : economicAccounts) {
				String threeDigit = ((ActivityEconomicAccount)economicAccount).getCode().substring(0, 3);
				if (aea.getCode().equals(threeDigit)) {
					aea = aea.sumActivityEconomicAccounts((ActivityEconomicAccount)economicAccount);
					//list2.add((ActivityEconomicAccount)economicAccount);
				}
			}
			list.add(aea);
		}
		Collections.sort(list);
		return list;
	}
		
	public List<Object> getActivityFinancesTest(Long activityUid) {
		return ((RepositoryActivity)getRepoEntity()).getActivityFinancesTest(activityUid);
	}
}
