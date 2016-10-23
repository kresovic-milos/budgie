package com.attozoic.main.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.attozoic.main.dao.DaoEntity;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceEntity;

@Service
public class ServiceEntityImpl implements ServiceEntity {

	@Autowired
	private DaoEntity daoEntity;

	@Override
	public Page<SuperEntity> findAll() {
		return daoEntity.findAll();
	}

	@Override
	public SuperEntity findOne(Long uid) {
		return daoEntity.findOne(uid);
	}

	@Override
	public SuperEntity save(SuperEntity superEntity) {
		return daoEntity.save(superEntity);
	}

	@Override
	public SuperEntity update(SuperEntity superEntity) {
		return daoEntity.update(superEntity);
	}

	@Override
	public void delete(Long uid) {
		daoEntity.delete(uid);
	}

	@Override
	public void archive(Long uid) {
		daoEntity.archive(uid);
	}

	@Override
	public void unarchive(Long uid) {
		daoEntity.unarchive(uid);
	}
	
	
}
