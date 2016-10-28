package com.attozoic.categories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.attozoic.categories.model.CategorySuperEntity;
import com.attozoic.main.model.ActiveState;

@NoRepositoryBean
public interface RepositoryCategoryEntity <T extends CategorySuperEntity> extends CrudRepository<T, Long> {
	List<T> findAll();
	T findOne(Long uid);
	T save(T superEntity);
	void delete(Long uid);
	boolean exists(Long uid);
	List<T> findByActiveState(ActiveState activeState);
}
