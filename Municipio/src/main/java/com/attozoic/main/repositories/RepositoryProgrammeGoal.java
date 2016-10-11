package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProgrammeGoal;

@Repository
public interface RepositoryProgrammeGoal extends CrudRepository<ProgrammeGoal, Long> {
	
	List<ProgrammeGoal> findAll();
	@SuppressWarnings("unchecked")
	ProgrammeGoal save(ProgrammeGoal goal);

}
