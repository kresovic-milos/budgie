package com.attozoic.main.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class DtoFinancialSourceYearAmount {

	// 1 Red u listi Finansijskih izvora
	
	private String name;
	private List<Double> amounts;
	
	public DtoFinancialSourceYearAmount() {}
	
	public DtoFinancialSourceYearAmount(String name, List<Double> amounts) {
		this.name = name;
		this.amounts = amounts;
	}
	
	public void generateAmounts(int numBalances) {
		for (int i = 0; i < numBalances; i++) {
			this.amounts.add(new Double(0));
		}
	}
	
	
	
}
