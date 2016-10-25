package com.attozoic.main.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoProject;
import com.attozoic.main.model.Project;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.ProjectGoal;
import com.attozoic.main.services.ServiceProject;

@Service
public class ServiceProjectImpl extends ServiceEntityImpl implements ServiceProject {

	@Autowired
	private DaoProject dao;
	
	@Override
	public DaoEntity getDaoEntity() {
		return dao;
	}
	
	@Override
	public ProjectFinancialSource addFinancialSource(Long uid, ProjectFinancialSource financialSource) {		
		return (ProjectFinancialSource) getDaoEntity().save(financialSource);
	}
	
	@Override
	public ProjectGoal addGoal(Long uid, ProjectGoal goal) {
		return (ProjectGoal) getDaoEntity().save(goal);
	}
	
}
