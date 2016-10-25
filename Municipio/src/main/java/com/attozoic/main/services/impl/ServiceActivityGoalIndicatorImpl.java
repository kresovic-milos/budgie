package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoActivityGoalIndicator;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.services.ServiceActivityGoalIndicator;

@Service
public class ServiceActivityGoalIndicatorImpl extends ServiceEntityImpl implements ServiceActivityGoalIndicator {
	
	@Autowired
	private DaoActivityGoalIndicator dao;

	@Override
	public DaoEntity getDaoEntity() {
		return dao;
	}
	
}
