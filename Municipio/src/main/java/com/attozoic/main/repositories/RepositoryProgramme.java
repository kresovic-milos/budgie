package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Programme;
import com.attozoic.main.model.ProgrammeGoal;

@Repository
public interface RepositoryProgramme extends RepositoryEntity<Programme> {
	
	@Query("from ProgrammeGoal goal where goal.programme.uid=:programmeUid and goal.activeState = 0")
	public List<ProgrammeGoal> getProgrammeGoals(@Param("programmeUid") Long uid);
	
}
