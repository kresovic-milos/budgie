package com.attozoic.main.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.dto.DtoFunction;
import com.attozoic.main.model.dto.DtoFunction2;
import com.attozoic.main.repositories.RepositoryActivityEconomicAccount;
import com.attozoic.main.repositories.RepositoryEntity;
import com.attozoic.main.repositories.RepositoryProjectEconomicAccount;

@Repository
public class DaoActivityEconomicAccount extends DaoEntity {

	@Autowired
	private RepositoryActivityEconomicAccount repoActivityEconomicAccount;
	
	@Autowired
	private RepositoryProjectEconomicAccount repoProjectEconomicAccount;
	
	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryEntity getRepoEntity() {
		return repoActivityEconomicAccount;
	}
	
	public List<DtoFunction> getFunctions2017B() {
		List<DtoFunction> list = new ArrayList<>();
		Map<String, Double> map = new HashMap<>();
		List<Object> activityFunctions = repoActivityEconomicAccount.getFunctions2017B();
		List<Object> projectFunctions = repoProjectEconomicAccount.getFunctions2017B();
		activityFunctions.addAll(projectFunctions);
		for (Object object : activityFunctions) {
			Object[] arr1 = (Object[])object;
			String s1 = (String)arr1[0];
			double d1 = (double)arr1[1];
			if (map.containsKey(s1)) {
				double d = map.get(s1) + d1;
				map.put(s1, d);
			} else {
				map.put(s1, d1);
			}
		}
		for (Map.Entry<String, Double> entry : map.entrySet()) {
			DtoFunction dto = new DtoFunction();
			dto.setName(entry.getKey());
			dto.setAmount(entry.getValue());
			list.add(dto);
		}
		return list;
	}
	
	public List<DtoFunction> getFunctions2017O() {
		List<DtoFunction> list = new ArrayList<>();
		Map<String, Double> map = new HashMap<>();
		List<Object> activityFunctions = repoActivityEconomicAccount.getFunctions2017O();
		List<Object> projectFunctions = repoProjectEconomicAccount.getFunctions2017O();
		activityFunctions.addAll(projectFunctions);
		for (Object object : activityFunctions) {
			Object[] arr1 = (Object[])object;
			String s1 = (String)arr1[0];
			double d1 = (double)arr1[1];
			if (map.containsKey(s1)) {
				double d = map.get(s1) + d1;
				map.put(s1, d);
			} else {
				map.put(s1, d1);
			}
		}
		for (Map.Entry<String, Double> entry : map.entrySet()) {
			DtoFunction dto = new DtoFunction();
			dto.setName(entry.getKey());
			dto.setAmount(entry.getValue());
			list.add(dto);
		}
		return list;
	}
	
	public List<DtoFunction2> getFunctions() {
		List<DtoFunction2> list = new ArrayList<>();
		List<DtoFunction> l1 = getFunctions2017B();
		List<DtoFunction> l2 = getFunctions2017O();
		System.out.println(l1.size());
		System.out.println(l2.size());
		for (DtoFunction d1 : l1) {
			for (DtoFunction d2 : l2) {
				if (d1.getName().equals(d2.getName())) {
					DtoFunction2 dto = new DtoFunction2();
					dto.setName(d1.getName());
					dto.setCode(d1.getName().substring(0, 3));
					List<Double> amounts = new ArrayList<>();
					amounts.add(d1.getAmount());
					amounts.add(d2.getAmount());
					dto.setAmounts(amounts);
					list.add(dto);
				}
			}
		}
		Collections.sort(list);
		return list;
	}
	
	public List<Object> getExpencesG() {
		return ((RepositoryActivityEconomicAccount)getRepoEntity()).getExpences2017B();
	}
	
	public List<SuperEconomicAccount> getAllExpences() {
		return ((RepositoryActivityEconomicAccount)getRepoEntity()).getAllExpences();
	}
	
	public double get411Sum() {
		return ((RepositoryActivityEconomicAccount)getRepoEntity()).get411Sum();
	}
	
	public double get412Sum() {
		return ((RepositoryActivityEconomicAccount)getRepoEntity()).get412Sum();
	}
	
}
