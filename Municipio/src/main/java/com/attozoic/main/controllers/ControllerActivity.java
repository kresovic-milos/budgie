package com.attozoic.main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.services.ServiceActivity;
import com.attozoic.main.services.ServiceActivityFinancialSource;

@RestController
@RequestMapping("/activities")
public class ControllerActivity {

	@Autowired
	private ServiceActivity serviceActivity;
	
	@Autowired
	private ServiceActivityFinancialSource serviceFinSrc;
	
	@RequestMapping(method = RequestMethod.GET) 
	public Page<Activity> getAllActivities() {
		return serviceActivity.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Activity addActivity(@RequestBody Activity activity) {
		return serviceActivity.save(activity);
	}
	
//	@RequestMapping(value="/{uid}/finsrc", method = RequestMethod.PUT)
//	public ActivityFinancialSource addActivityFinancialSource(@PathVariable(value="uid") Long uid, @RequestBody ActivityFinancialSource financialSource) {
//		Activity a = serviceActivity.findOneById(financialSource.getActivities().get(0).getUid());
//		List<Activity> aList = new ArrayList<>();
//		aList.add(a);
//		financialSource.setActivities(aList);
//		ActivityFinancialSource finSrc = serviceFinSrc.save(financialSource);
//		a.getActivityFinancialSources().add(finSrc);
//		serviceActivity.save(a);
//		
//		return finSrc;
//	}
}
