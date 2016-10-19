package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.ActivityGoal;

public interface ServiceActivityGoal {

	Page<ActivityGoal> findAll();
	ActivityGoal save(ActivityGoal activityGoal);

}
