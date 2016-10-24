package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProgrammeGoalIndicator;
import com.attozoic.main.services.ServiceProgrammeGoalIndicator;

@Service
public class ServiceProgrammeGoalIndicatorImpl extends ServiceEntityImpl implements ServiceProgrammeGoalIndicator {

	@Autowired
	private DaoProgrammeGoalIndicator dao;

	@Override
	public DaoEntity getDaoEntity() {
		return dao;
	}
	
}
