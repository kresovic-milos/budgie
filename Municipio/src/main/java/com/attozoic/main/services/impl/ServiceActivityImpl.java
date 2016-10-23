package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivity;
import com.attozoic.main.model.Activity;
import com.attozoic.main.services.ServiceActivity;

@Service
public class ServiceActivityImpl implements ServiceActivity {

	@Autowired
	private DaoActivity daoActivity;

	@Override
	public Page<Activity> findAll() {
		return daoActivity.findAll();
	}

	@Override
	public Activity save(Activity activity) {
		return daoActivity.save(activity);
	}

	@Override
	public Activity findOneById(Long uid) {
		// TODO Auto-generated method stub
		return daoActivity.findOneById(uid);
	}
	
}
