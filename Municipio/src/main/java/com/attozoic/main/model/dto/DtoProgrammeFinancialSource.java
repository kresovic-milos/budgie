package com.attozoic.main.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

// 1. DTO FinancialSource of Programme (sum financial sources from activities/projects for 1 name)
@Data
public class DtoProgrammeFinancialSource {

	private String name;
	
	private double sourceBaseYear; // 2016
	private double sourceBaseYearPlus1; // 2017
	private double sourceBaseYearPlus2; // 2018
	private double sourceBaseYearPlus3; // 2019
	private double sumSources123;
	
	private List<Double> listSourceRebalance = new ArrayList<>();

	public DtoProgrammeFinancialSource() {}
	
	public void dtoFinancePlusDtoFinance(DtoProgrammeFinancialSource dtoFinance) {
		this.setSourceBaseYear(this.getSourceBaseYear() + dtoFinance.getSourceBaseYear());
		this.setSourceBaseYearPlus1(this.getSourceBaseYearPlus1() + dtoFinance.getSourceBaseYearPlus1());
		this.setSourceBaseYearPlus2(this.getSourceBaseYearPlus2() + dtoFinance.getSourceBaseYearPlus2());
		this.setSourceBaseYearPlus3(this.getSourceBaseYearPlus3() + dtoFinance.getSourceBaseYearPlus3());
		this.setSumSources123(this.getSumSources123() + dtoFinance.getSumSources123());
		plusRebBudget(dtoFinance.getListSourceRebalance());
	}

	public void plusRebBudget(List<Double> list) {
		for (int i = 0; i < this.getListSourceRebalance().size(); i++) {
			double d = this.getListSourceRebalance().get(i) + list.get(i);
			this.getListSourceRebalance().set(i, d);
			//this.getListSourceRebalance().set(i, (this.getListSourceRebalance().get(i) + list.get(i)));
			
		}
	}

}
