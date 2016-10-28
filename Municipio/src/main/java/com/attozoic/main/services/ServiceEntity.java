package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.SuperEntity;

public interface ServiceEntity {
	Page<SuperEntity> findAll();
	SuperEntity findOne(Long uid);
	SuperEntity save(SuperEntity superEntity);
	SuperEntity update(SuperEntity superEntity);
	void delete(Long uid);
	void archive(Long uid);
	void unarchive(Long uid);
	Page<SuperEntity> findActive();
	Page<SuperEntity> findArchived();
}
