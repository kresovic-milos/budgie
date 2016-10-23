package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.Activity;

public interface ServiceActivity {

	Page<Activity> findAll();
	Activity save(Activity activity);
	Activity findOneById(Long uid);

}
