package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.Programme;

public interface ServiceProgramme {

	Page<Programme> findAll();
	Programme save(Programme programme);

}
