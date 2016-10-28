package com.attozoic.categories.services.impl;

import org.springframework.data.domain.Page;

import com.attozoic.categories.dao.DaoCategoryEntity;
import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.categories.services.ServiceCategoryEntity;

public abstract class ServiceCategoryEntityImpl implements ServiceCategoryEntity {

	public abstract DaoCategoryEntity getDaoCategoryEntity();
	
	@Override
	public Page<CategorySuperEntity> findAll() {
		return getDaoCategoryEntity().findAll();
	}

	@Override
	public CategorySuperEntity findOne(Long uid) {
		return getDaoCategoryEntity().findOne(uid);
	}

	@Override
	public CategorySuperEntity save(CategorySuperEntity categorySuperEntity) {
		return getDaoCategoryEntity().save(categorySuperEntity);
	}

	@Override
	public CategorySuperEntity update(CategorySuperEntity categorySuperEntity) {
		return getDaoCategoryEntity().update(categorySuperEntity);
	}

	@Override
	public void delete(Long uid) {
		getDaoCategoryEntity().delete(uid);
	}

	@Override
	public void archive(Long uid) {
		getDaoCategoryEntity().archive(uid);
	}

	@Override
	public void unarchive(Long uid) {
		getDaoCategoryEntity().unarchive(uid);
	}

	@Override
	public Page<CategorySuperEntity> findActive() {
		return getDaoCategoryEntity().findActive();
	}

	@Override
	public Page<CategorySuperEntity> findArchived() {
		return getDaoCategoryEntity().findArchived();
	}
	
}
