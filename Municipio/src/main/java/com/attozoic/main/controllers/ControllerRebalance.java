package com.attozoic.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.services.ServiceEntityWithRebalances;
import com.attozoic.main.services.ServiceRebalancesCount;

@RestController
@RequestMapping("/rebalances")
public class ControllerRebalance {

	@Autowired
	private ServiceEntityWithRebalances serviceEntityWithRebalances;
	
	@Autowired
	private ServiceRebalancesCount serviceRebalanceCount;

	//getRebalancesCount
	@RequestMapping(value="/count", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int getRebalancesCount() {
		if (!getAllCounts().hasContent()) {
			RebalancesCount rc = new RebalancesCount();
			serviceRebalanceCount.save(rc);
		}
		return ((RebalancesCount)serviceRebalanceCount.findOne(new Long(1))).getRebalancesCount();
	}
	
	//addRebalance(+1 column with empty values)
	@RequestMapping(value="/add", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int addRebalance() {
		serviceEntityWithRebalances.addRebalance();
		return serviceRebalanceCount.rebalancePlus();
	}
	
	//removeRebalance(last one)
	@RequestMapping(value="/remove", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public int removeRebalance() {
		serviceEntityWithRebalances.removeRebalance();
		return serviceRebalanceCount.rebalanceMinus(1L);
	}
	
	private Page<SuperEntity> getAllCounts() {
		return serviceRebalanceCount.findAll();
	}
	
}
