package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ProgrammeGoalIndicator;

	@Repository
	public interface RepositoryProgrameGoalIndicator extends CrudRepository<ProgrammeGoalIndicator, Long> {

		List<ProgrammeGoalIndicator> findAll();
		@SuppressWarnings("unchecked")
		ProgrammeGoalIndicator save(ProgrammeGoalIndicator programmeGoalIndicator);
		
	}
