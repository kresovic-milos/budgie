package com.attozoic.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.Authority;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceAuthority;

@RestController
@RequestMapping("/authorities")
public class ControllerAuthority {

	@Autowired
	ServiceAuthority serviceAuthority;
	
	@RequestMapping(value="/{uid}/activities", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Activity> getActivitiesByUid(@PathVariable(value="uid") Long uid) {
		return serviceAuthority.findActivitiesByUid(uid);
	}
	
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getAllAuthorities(){
		return serviceAuthority.findAll();
	}
	// Vraca izabrani cilj programa po uid-u
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getAuthority(@PathVariable(value="uid") Long uid) {
		return serviceAuthority.findOne(uid);
	}
	
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveAuthorities() {
		return serviceAuthority.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedAuthorities() {
		return serviceAuthority.findArchived();
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Authority update(@RequestBody Authority authority) {
		return (Authority) serviceAuthority.save(authority);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceAuthority.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceAuthority.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceAuthority.unarchive(uid);
	}
	
}
