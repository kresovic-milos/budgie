package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;
import com.attozoic.main.repositories.RepositoryActivity;

@Repository
public class DaoActivity {

	@Autowired
	private RepositoryActivity repoActivity;
	
	public Page<Activity> findAll() {
		Page<Activity> page = new PageImpl<>(repoActivity.findAll());
		return page;
	}
	
	public Activity save(Activity activity) {
		return repoActivity.save(activity);
	}
	
}
