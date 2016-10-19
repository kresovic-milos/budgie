package com.attozoic.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Function;
import com.attozoic.main.repositories.RepositoryFunction;

@Repository
public class DaoFunction {
	
	@Autowired
	private RepositoryFunction repoFunction;
	
	public Page<Function> findAll() {
		Page<Function> page = new PageImpl<>(repoFunction.findAll());
		return page;
	}
	
	public Function save(Function function) {
		return repoFunction.save(function);
	}
	
}
