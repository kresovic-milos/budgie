package com.attozoic.main.model.dto;

import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.ThreeDigitEconomicAccount;

import lombok.Data;

@Data
public class DtoEconomicAccountTwoObjects {

	private SuperEconomicAccount superEconomicAccount;
	private ThreeDigitEconomicAccount threeDigitEconomicAccount;
	
	public DtoEconomicAccountTwoObjects() {}
	
	public DtoEconomicAccountTwoObjects(SuperEconomicAccount superEconomicAccount, ThreeDigitEconomicAccount threeDigitEconomicAccount) {
		this.superEconomicAccount = superEconomicAccount;
		this.threeDigitEconomicAccount = threeDigitEconomicAccount;
	}
	
}
