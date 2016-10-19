package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.ActivityGoalIndicator;

@Repository
public interface RepositoryActivityGoalIndicator extends CrudRepository<ActivityGoalIndicator, Long> {

	List<ActivityGoalIndicator> findAll();
	@SuppressWarnings("unchecked")
	ActivityGoalIndicator save(ActivityGoalIndicator activityGoalIndicator);
	
}
