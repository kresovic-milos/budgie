package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.Activity;
import com.attozoic.main.services.ServiceActivity;

@RestController
@RequestMapping("/activities")
public class ControllerActivity {

	@Autowired
	private ServiceActivity serviceActivity;
	
	@RequestMapping(method = RequestMethod.GET) 
	public Page<Activity> getAllActivities() {
		return serviceActivity.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Activity addActivity(@RequestBody Activity activity) {
		return serviceActivity.save(activity);
	}
}
