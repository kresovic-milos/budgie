package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.SuperEntity;

@Repository
public interface RepositoryEntity extends CrudRepository<SuperEntity, Long> {
	
	List<SuperEntity> findAll();
	SuperEntity findOne(Long uid);
	@SuppressWarnings("unchecked")
	SuperEntity save(SuperEntity superEntity);
	//SuperEntity update(SuperEntity superEntity);
	void delete(Long uid);
	
	
}
