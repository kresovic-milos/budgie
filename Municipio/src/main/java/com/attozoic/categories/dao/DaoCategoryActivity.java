package com.attozoic.categories.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

import com.attozoic.categories.model.CategoryActivity;
import com.attozoic.categories.repositories.RepositoryCategoryActivity;

@Repository
public class DaoCategoryActivity {

	@Autowired
	private RepositoryCategoryActivity repoActivity;
	
	public Page<CategoryActivity> findAll() {
		Page<CategoryActivity> page = new PageImpl<>(repoActivity.findAll());
		return page;
	}
	
	public CategoryActivity save(CategoryActivity activity) {
		return repoActivity.save(activity);
	}
	
}
