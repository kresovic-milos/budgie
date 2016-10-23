package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.ProjectGoal;

public interface ServiceProjectGoal {

	Page<ProjectGoal> findAll();
	ProjectGoal save(ProjectGoal projectGoal);

}
