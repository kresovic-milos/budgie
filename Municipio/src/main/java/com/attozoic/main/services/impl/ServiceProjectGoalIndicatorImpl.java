package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProjectGoalIndicator;
import com.attozoic.main.services.ServiceProjectGoalIndicator;

@Service
public class ServiceProjectGoalIndicatorImpl extends ServiceEntityImpl implements ServiceProjectGoalIndicator {
	
	@Autowired
	private DaoProjectGoalIndicator dao;

	@Override
	public DaoEntity getDaoEntity() {
		return dao;
	}
}
