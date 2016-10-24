package com.attozoic.main.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.Programme;
import com.attozoic.main.model.ProgrammeGoal;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceActivity;
import com.attozoic.main.services.ServiceActivityFinancialSource;

@RestController
@RequestMapping("/activities")
public class ControllerActivity {

	@Autowired
	private ServiceActivity serviceActivity;
	
//	@Autowired
//	private ServiceActivityFinancialSource serviceFinSrc;
	
	@RequestMapping(method = RequestMethod.GET) 
	public Page<SuperEntity> getAll() {
		return serviceActivity.findAll();
	}
	
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getOne(@PathVariable(value="uid") Long uid) {
		return serviceActivity.findOne(uid);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public SuperEntity save(@RequestBody Activity activity) {
		return serviceActivity.save(activity);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Activity update(@RequestBody Activity activity) {
		return (Activity) serviceActivity.save(activity);
	}
	
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceActivity.delete(uid);
	}
	
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceActivity.archive(uid);
	}
	
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceActivity.unarchive(uid);
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
