package com.attozoic.main.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.dao.DaoActivity;
import com.attozoic.main.model.Activity;
import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ActivityGoal;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.ThreeDigitEconomicAccount;
import com.attozoic.main.model.dto.DtoActivityEconomicAccount;
import com.attozoic.main.services.ServiceActivity;
import com.attozoic.main.services.ServiceThreeDigitEconomicAccount;

@RestController
@RequestMapping("/activities")
public class ControllerActivity {

	@Autowired
	private ServiceActivity serviceActivity;
	
	@Autowired
	private ServiceThreeDigitEconomicAccount serviceThreeDigitEconomicAccount;
	
	@Autowired
	public DaoActivity daoActivity;
	
	
	@RequestMapping(value="/{uid}/ttt", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> getActivityFinancesTest(@PathVariable(value="uid") Long uid) {
		return serviceActivity.getActivityFinancesTest(uid);
	}
	
	//getActivitiesByAuthority{authorityCode}
	@RequestMapping(value="/{autorityCode}/r", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Activity> getActivitiesByAuthority(@PathVariable(value="autorityCode") String autorityCode) {
		return serviceActivity.getActivitiesByAuthority(autorityCode);
	}
	
	//getActivityEconomicAccounts{uid}
	@RequestMapping(value="/{uid}/economicAccounts", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<SuperEconomicAccount> getActivityEconomicAccounts(@PathVariable(value="uid") Long uid) {
		return serviceActivity.getActivityExpences(uid);
	}
	
	//getActivityFinancialSources{uid}
//	@RequestMapping(value="/{uid}/financialSources", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public List<ActivityFinancialSource> getActivityFinancialSources(@PathVariable(value="uid") Long uid) {
//		return serviceActivity.getActivityFinances(uid);
//	}
	
	// Izvori finansiranja aktivnosti - Kresina Lista Objekata - Ne koristim je sada
	@RequestMapping(value="/{uid}/f", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> getActivityFinancial(@PathVariable(value="uid") Long uid) {
		return serviceActivity.getActivityFinancial(uid);
	}
	
	//getActivityGoals{uid}
	@RequestMapping(value="/{uid}/goals", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<ActivityGoal> getActivityGoals(@PathVariable(value="uid") Long uid) {
		return serviceActivity.getActivityGoals(uid);
	}
	
	//getActivityFinancialSourceFooter{uid}
	@RequestMapping(value="/{uid}/financesFooter", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Double> getActivityFinancialSourceFooter(@PathVariable(value="uid") Long uid) {
		return serviceActivity.getActivityExpencesFooter(uid);
	}
	
	//getActivityFinancialSourceMap{uid}
	@RequestMapping(value="/{uid}/finances", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, double[]> getActivityFinancialSourceMap(@PathVariable(value="uid") Long uid) {
		return serviceActivity.getActivityFinancialSourceMap(uid);
	}
	
	//getActivityEconomicAccountFooter{uid}
	@RequestMapping(value="/{uid}/expencesFooter", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Double> getActivityEconomicAccountFooter(@PathVariable(value="uid") Long uid) {
		return serviceActivity.getActivityExpencesFooter(uid);
	}
	
	//getActivityEconomicAccountsList{uid}
	@RequestMapping(value="/{uid}/expences", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<DtoActivityEconomicAccount> getActivityEconomicAccountsList(@PathVariable(value="uid") Long uid) {
		return serviceActivity.getActivityExpencesList(uid);
	}

	//addActivityGoal to Activity{uid}
	@RequestMapping(value="/{uid}/activityGoals", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityGoal addActivityGoal(@PathVariable(value="uid") Long uid, @RequestBody ActivityGoal activityGoal) {
		return serviceActivity.addActivityGoal(uid, activityGoal);
	}
	
	//addActivityEconomicAccount to Activity{uid}
	@RequestMapping(value="/{uid}/activityEconomicAccounts", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ActivityEconomicAccount addActivityEconomicAccount(@PathVariable(value="uid") Long uid, @RequestBody ActivityEconomicAccount activityEconomicAccount, @RequestBody ThreeDigitEconomicAccount threeDigitEconomicAccount) {
		if (!threeDigitEconomicAccount.equals(null)) {
			serviceThreeDigitEconomicAccount.save(threeDigitEconomicAccount);
		}
		return serviceActivity.addActivityEconomicAccount(uid, activityEconomicAccount);
	}
	
	//getAllActivities
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Page<SuperEntity> getAllActivities() {
		return serviceActivity.findAll();
	}
	
	//getActivity{uid}
	@RequestMapping(value="/{uid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SuperEntity getActivity(@PathVariable(value="uid") Long uid) {
		return serviceActivity.findOne(uid);
	}
	
	//getActiveActivities
	@RequestMapping(value="/active", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getActiveActivities() {
		return serviceActivity.findActive();
	}
	
	//getArchivedActivities
	@RequestMapping(value="/archived", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Page<SuperEntity> getArchivedActivities() {
		return serviceActivity.findArchived();
	}
	
//	//saveActivity
//	@RequestMapping(method = RequestMethod.POST)
//	public SuperEntity save(@RequestBody Activity activity) {
//		return serviceActivity.save(activity);
//	}
	
	//updateActivity
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Activity update(@RequestBody Activity activity) {
		return (Activity) serviceActivity.update(activity);
	}
	
	//deleteActivity{uid}
	@RequestMapping(value="{uid}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable(value="uid") Long uid) {
		serviceActivity.delete(uid);
	}
	
	//archiveActivity{uid}
	@RequestMapping(value="{uid}/archive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void archive(@PathVariable(value="uid") Long uid) {
		serviceActivity.archive(uid);
	}
	
	//unarchiveActivity{uid}
	@RequestMapping(value="{uid}/unarchive", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void unarchive(@PathVariable(value="uid") Long uid) {
		serviceActivity.unarchive(uid);
	}

	////////////////matrix //////////////

	@RequestMapping(value="/{uid}/expencesGroups", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
		public List<ActivityEconomicAccount> getExpencesGroups(@PathVariable(value="uid") Long uid) {
		return daoActivity.getActivityExpencesGroups(uid);
	}
	
}
