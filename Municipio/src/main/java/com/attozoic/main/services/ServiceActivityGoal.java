package com.attozoic.main.services;

import com.attozoic.main.model.ActivityGoalIndicator;

public interface ServiceActivityGoal extends ServiceEntity {

	ActivityGoalIndicator addActivityGoalIndicator(Long uid, ActivityGoalIndicator activityGoalIndicator);

}
