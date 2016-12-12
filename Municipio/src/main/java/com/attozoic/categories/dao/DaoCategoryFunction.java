package com.attozoic.categories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.repositories.RepositoryCategoryEntity;
import com.attozoic.categories.repositories.RepositoryCategoryFunction;

@Repository
public class DaoCategoryFunction extends DaoCategoryEntity {
	
	@Autowired
	private RepositoryCategoryFunction repoFunction;

	@SuppressWarnings("rawtypes")
	@Override
	public RepositoryCategoryEntity getCategoryRepoEntity() {
		return repoFunction;
	}
	
	public Map<String, String> getOneDigits() {
		Map<String, String> map = new HashMap<String, String>();
		List<Object> list = ((RepositoryCategoryFunction)getCategoryRepoEntity()).getOneDigits();
		for (Object object : list) {
			Object[] objects = (Object[])object;
			map.put((String)objects[0], ((String)objects[1]).trim());
		}
		return map;
	}

}
