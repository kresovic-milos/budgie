package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceActivity;

@RestController
@RequestMapping("/activities")
public class ControllerActivity {

	@Autowired
	private ServiceActivity serviceActivity;
	
	// getAll
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAll() {
		return serviceActivity.findAll();
	}
	
	// getOne
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getOne(@PathVariable(value="uid") Long uid) {
		return serviceActivity.findOne(uid);
	}
	
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveSectors() {
		return serviceActivity.findActive();
	}
	
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedSectors() {
		return serviceActivity.findArchived();
	}
	
	// addOne
	@RequestMapping(method = RequestMethod.POST)
	public SuperEntity save(@RequestBody Activity activity) {
		return serviceActivity.save(activity);
	}
	
	// addGoal to Activity
	@RequestMapping(value="/{uid}/activityGoals", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityGoal addActivityGoal(@PathVariable(value="uid") Long uid, @RequestBody ActivityGoal activityGoal) {
		return serviceActivity.addActivityGoal(uid, activityGoal);
	}
	
	// addFinancialSource to Activity
	@RequestMapping(value="/{uid}/activityFinancialSources", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityFinancialSource addFinancialSource(@PathVariable(value="uid") Long uid, @RequestBody ActivityFinancialSource activityFinancialSource) {
		return serviceActivity.addActivityFinancialSource(uid, activityFinancialSource);
	}
	
	// addEconimcalAccount to Activity
	@RequestMapping(value="/{uid}/activityEconomicAccounts", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityEconomicAccount addEconomic(@PathVariable(value="uid") Long uid, @RequestBody ActivityEconomicAccount activityEconomicAccount) {
		//Activity a = (Activity)serviceActivity.findOne(uid);
		//System.err.println(a.getName());
		return serviceActivity.addActivityEconomicAccount(uid, activityEconomicAccount);
	}
	
	// updateActivity
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Activity update(@RequestBody Activity activity) {
		return (Activity) serviceActivity.save(activity);
	}
	
	// deleteActivity
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceActivity.delete(uid);
	}
	
	// archiveActivity
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceActivity.archive(uid);
	}
	
	// unarchiveActivity
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceActivity.unarchive(uid);
	}

}
