package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectGoalIndicator;

@Repository
public interface RepositoryProjectGoalIndicator extends CrudRepository<ProjectGoalIndicator, Long> {

	List<ProjectGoalIndicator> findAll();
	@SuppressWarnings("unchecked")
	ProjectGoalIndicator save(ProjectGoalIndicator projectGoalIndicator);
	
}
