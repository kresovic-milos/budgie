package com.attozoic.main.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoAuthority;
import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.Activity;
import com.attozoic.main.services.ServiceAuthority;

@Service
public class ServiceAuthorityImpl extends ServiceEntityImpl implements ServiceAuthority {

	@Autowired
	private DaoAuthority daoAuthority;

	@Override
	public DaoEntity getDaoEntity() {
		return daoAuthority;
	}

	@Override
	public List<Activity> findActivitiesByUid(Long uid) {
		return ((DaoAuthority)getDaoEntity()).findActivitiesByUid(uid);
	}
	
}
