package com.attozoic.categories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.repositories.RepositoryCategoryEconomicAccount;
import com.attozoic.categories.repositories.RepositoryCategoryEntity;

@Repository
public class DaoCategoryEconomicAccount extends DaoCategoryEntity {

	@Autowired
	private RepositoryCategoryEconomicAccount repoEconomicAccount;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoEconomicAccount;
	}
	
	public Map<String, String> getThreeDigits() {
		Map<String, String> map = new HashMap<String, String>();
		List<Object> list = ((RepositoryCategoryEconomicAccount)getCategoryRepoEntity()).getThreeDigits();
		for (Object object : list) {
			Object[] objects = (Object[])object;
			map.put((String)objects[0], ((String)objects[1]).trim());
		}
		return map;
	}
	
	public Map<String, String> getTwoDigits() {
		Map<String, String> map = new HashMap<String, String>();
		List<Object> list = ((RepositoryCategoryEconomicAccount)getCategoryRepoEntity()).getTwoDigits();
		for (Object object : list) {
			Object[] objects = (Object[])object;
			map.put((String)objects[0], ((String)objects[1]).trim());
		}
		return map;
	}
	
	public Map<String, String> getOneDigits() {
		Map<String, String> map = new HashMap<String, String>();
		List<Object> list = ((RepositoryCategoryEconomicAccount)getCategoryRepoEntity()).getOneDigits();
		for (Object object : list) {
			Object[] objects = (Object[])object;
			map.put((String)objects[0], ((String)objects[1]).trim());
		}
		return map;
	}
	
}
