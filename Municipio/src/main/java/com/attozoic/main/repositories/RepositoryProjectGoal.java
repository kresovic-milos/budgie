package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProjectGoal;

@Repository
public interface RepositoryProjectGoal extends CrudRepository<ProjectGoal, Long> {

	List<ProjectGoal> findAll();
	@SuppressWarnings("unchecked")
	ProjectGoal save(ProjectGoal projectGoal);
	
}
