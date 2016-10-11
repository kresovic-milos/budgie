package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryFunction;
import com.attozoic.categories.repositories.RepositoryCategoryFunction;

@Repository
public class DaoCategoryFunction {
	
	@Autowired
	private RepositoryCategoryFunction repoFunction;
	
	public Page<CategoryFunction> findAll() {
		Page<CategoryFunction> page = new PageImpl<>(repoFunction.findAll());
		return page;
	}
	
	public CategoryFunction save(CategoryFunction function) {
		return repoFunction.save(function);
	}
	
}
