package com.attozoic.main.model.dto;

import lombok.Data;

@Data
public class DtoFinancialSource {

	private String name;
	private double year;
	private double amount;
	
	public DtoFinancialSource() {}
	
	public DtoFinancialSource(String name, double year, double amount) {
		this.name = name;
		this.year = year;
		this.amount = amount;
	}
	
	public void sumDtoFinancialSources(DtoFinancialSource dtoFinancialSource) {
		this.setAmount(this.getAmount() + dtoFinancialSource.getAmount());
	}
	
	public DtoFinancialSource sumDtoFinancialSourcesReturnDTO(DtoFinancialSource dtoFinancialSource) {
		return new DtoFinancialSource(this.getName(), this.getYear(), this.getAmount() + dtoFinancialSource.getAmount());
	}
	
}
