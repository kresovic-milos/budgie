package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Project;
import com.attozoic.main.repositories.RepositoryProject;

@Repository
public class DaoProject {

	@Autowired
	private RepositoryProject repoProject;
	
	public Page<Project> findAll() {
		Page<Project> page = new PageImpl<>(repoProject.findAll());
		return page;
	}
	
	public Project save(Project project) {
		return repoProject.save(project);
	}
	
}
