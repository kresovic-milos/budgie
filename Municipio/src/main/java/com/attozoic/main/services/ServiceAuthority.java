package com.attozoic.main.services;

import java.util.List;

import com.attozoic.main.model.Activity;

public interface ServiceAuthority extends ServiceEntity {

	public List<Activity> findActivitiesByUid(Long uid);
}
