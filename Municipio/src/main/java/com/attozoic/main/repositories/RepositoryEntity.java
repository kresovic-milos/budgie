package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.SuperEntity;

@NoRepositoryBean
public interface RepositoryEntity<T extends SuperEntity> extends CrudRepository<T, Long> {
	List<T> findAll();
	T findOne(Long uid);
	T save(T superEntity);
	void delete(Long uid);
	boolean exists(Long uid);
	List<T> findByActiveState(ActiveState activeState);
}
