package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.dao.DaoFunction;
import com.attozoic.main.services.ServiceFunction;

@Service
public class ServiceFunctionImpl extends ServiceEntityImpl implements ServiceFunction {

	@Autowired
	DaoFunction daoFunction;

	@Override
	public DaoEntity getDaoEntity() {
		return daoFunction;
	}

}
