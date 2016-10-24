package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.SuperEntity;

@NoRepositoryBean
public interface RepositoryEntity<T extends SuperEntity> extends CrudRepository<T, Long> {
	
	List<T> findAll();
	T findOne(Long uid);
	@SuppressWarnings("unchecked")
	T save(T superEntity);
	//SuperEntity update(SuperEntity superEntity);
	void delete(Long uid);
	
	
}
