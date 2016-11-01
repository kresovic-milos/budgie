package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoHead;
import com.attozoic.main.services.ServiceHead;

@Service
public class ServiceHeadImpl extends ServiceEntityImpl implements ServiceHead {

	@Autowired
	private DaoHead daoHead;
	
	@Override
	public DaoEntity getDaoEntity() {
		return daoHead;
	}

}
