package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoFunction;
import com.attozoic.main.model.Function;
import com.attozoic.main.services.ServiceFunction;

@Service
public class ServiceFunctionImpl implements ServiceFunction {

	@Autowired
	DaoFunction daoFunction;

	@Override
	public Page<Function> findAll() {
		return daoFunction.findAll();
	}

	@Override
	public Function save(Function function) {
		return daoFunction.save(function);
	}
}
