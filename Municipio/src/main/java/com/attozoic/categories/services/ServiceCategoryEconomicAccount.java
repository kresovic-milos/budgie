package com.attozoic.categories.services;

import java.util.Map;

public interface ServiceCategoryEconomicAccount extends ServiceCategoryEntity {
	
	Map<String, String> getThreeDigits();
	Map<String, String> getTwoDigits();
	Map<String, String> getOneDigits();
}