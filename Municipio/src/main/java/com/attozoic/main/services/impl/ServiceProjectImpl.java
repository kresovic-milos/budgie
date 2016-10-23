package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoProject;
import com.attozoic.main.model.Project;
import com.attozoic.main.services.ServiceProject;

@Service
public class ServiceProjectImpl implements ServiceProject {

	@Autowired
	private DaoProject daoProject;

	@Override
	public Page<Project> findAll() {
		return daoProject.findAll();
	}

	@Override
	public Project save(Project project) {
		return daoProject.save(project);
	}
	
}
