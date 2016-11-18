package com.attozoic.main.model.dto;

import lombok.Data;

@Data
public class DtoFinanceFooter {

	private String name;
	private double[] amounts;
 	
	public DtoFinanceFooter() {}
	
	public DtoFinanceFooter(String name, double[] amounts) {
		this.name = name;
		this.amounts = amounts;
	}
	
}
