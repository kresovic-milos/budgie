package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.Project;

public interface ServiceProject {

	Page<Project> findAll();
	Project save(Project project);

}
