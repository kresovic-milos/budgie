package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.ActivityGoalIndicator;

public interface ServiceActivityGoalIndicator {

	Page<ActivityGoalIndicator> findAll();
	ActivityGoalIndicator save(ActivityGoalIndicator activityGoalIndicator);

}
