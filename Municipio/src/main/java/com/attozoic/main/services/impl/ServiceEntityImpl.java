package com.attozoic.main.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceEntity;

@Service
public abstract class ServiceEntityImpl implements ServiceEntity {

	public abstract DaoEntity getDaoEntity();

	@Override
	public Page<SuperEntity> findAll() {
		return getDaoEntity().findAll();
	}

	@Override
	public SuperEntity findOne(Long uid) {
		return getDaoEntity().findOne(uid);
	}

	@Override
	public SuperEntity save(SuperEntity superEntity) {
		return getDaoEntity().save(superEntity);
	}

	@Override
	public SuperEntity update(SuperEntity superEntity) {
		return getDaoEntity().update(superEntity);
	}

	@Override
	public void delete(Long uid) {
		getDaoEntity().delete(uid);
	}

	@Override
	public void archive(Long uid) {
		getDaoEntity().archive(uid);
	}

	@Override
	public void unarchive(Long uid) {
		getDaoEntity().unarchive(uid);
	}

	public Page<SuperEntity> findActive() {
		return getDaoEntity().findActive();
	}
	
	public Page<SuperEntity> findArchived() {
		return getDaoEntity().findArchived();
	}
	
}
