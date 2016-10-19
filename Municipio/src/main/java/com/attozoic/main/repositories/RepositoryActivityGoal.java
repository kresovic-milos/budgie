package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityGoal;

@Repository
public interface RepositoryActivityGoal extends CrudRepository<ActivityGoal, Long> {

	List<ActivityGoal> findAll();
	@SuppressWarnings("unchecked")
	ActivityGoal save(ActivityGoal programmeGoal);
	
}
