package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.Function;

public interface ServiceFunction {

	Page<Function> findAll();
	Function save(Function function);

}
