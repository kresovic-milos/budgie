package com.attozoic.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.attozoic.main.model.Activity;

@Repository
public interface RepositoryActivity extends CrudRepository<Activity, Long> {

	List<Activity> findAll();
	@SuppressWarnings("unchecked")
	Activity save(Activity activity);
	Activity findOne(Long uid);
	
}
