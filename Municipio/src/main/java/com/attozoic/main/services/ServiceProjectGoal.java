package com.attozoic.main.services;

import com.attozoic.main.model.ProjectGoalIndicator;

public interface ServiceProjectGoal extends ServiceEntity {

	ProjectGoalIndicator addIndicator(Long uid, ProjectGoalIndicator goalIndicator);

}
