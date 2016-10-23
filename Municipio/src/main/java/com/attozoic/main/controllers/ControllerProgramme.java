package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.Programme;
import com.attozoic.main.services.ServiceProgramme;

@RestController
@RequestMapping("/programmes")
public class ControllerProgramme {

	@Autowired
	private ServiceProgramme serviceProgramme;
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<Programme> getAllProgrammes() {
		return serviceProgramme.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Programme addProgramme(@RequestBody Programme programme) {
		return serviceProgramme.save(programme);
	}
}
