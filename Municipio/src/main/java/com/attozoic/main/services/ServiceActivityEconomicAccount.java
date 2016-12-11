package com.attozoic.main.services;

import java.util.List;

import com.attozoic.main.model.SuperEconomicAccount;

public interface ServiceActivityEconomicAccount extends ServiceEntity {
	
	List<SuperEconomicAccount> getAllExpences();
	
	double get411Sum();
	double get412Sum();
	
}
