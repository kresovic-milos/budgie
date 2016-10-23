package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.ProjectGoalIndicator;

public interface ServiceProjectGoalIndicator {

	Page<ProjectGoalIndicator> findAll();
	ProjectGoalIndicator save(ProjectGoalIndicator projectGoalIndicator);

}
