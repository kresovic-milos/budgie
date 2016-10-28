package com.attozoic.categories.services;

import org.springframework.data.domain.Page;

import com.attozoic.categories.model.CategorySuperEntity;

public interface ServiceCategoryEntity {
	Page<CategorySuperEntity> findAll();
	CategorySuperEntity findOne(Long uid);
	CategorySuperEntity save(CategorySuperEntity categorySuperEntity);
	CategorySuperEntity update(CategorySuperEntity categorySuperEntity);
	void delete(Long uid);
	void archive(Long uid);
	void unarchive(Long uid);
	Page<CategorySuperEntity> findActive();
	Page<CategorySuperEntity> findArchived();
}
