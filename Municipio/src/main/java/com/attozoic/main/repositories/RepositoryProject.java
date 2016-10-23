package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Project;

@Repository
public interface RepositoryProject extends CrudRepository<Project, Long> {

	List<Project> findAll();
	@SuppressWarnings("unchecked")
	Project save(Project project);
	
}
