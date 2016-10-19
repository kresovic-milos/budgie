package com.attozoic.main.services;

import org.springframework.data.domain.Page;

import com.attozoic.main.model.EconomicAccount;

public interface ServiceEconomicAccount {

	Page<EconomicAccount> findAll();
	EconomicAccount save(EconomicAccount economicAccount);

}
