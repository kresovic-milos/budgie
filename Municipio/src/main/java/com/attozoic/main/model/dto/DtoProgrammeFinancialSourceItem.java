package com.attozoic.main.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

// 1 DTO FinancialSource of Activity/Project (sum financial sources from expences) // MAP<name, dto>
@Data
public class DtoProgrammeFinancialSourceItem {

	private String name;
	
	private double sourceBaseYear; // 2016
	private double sourceBaseYearPlus1; // 2017
	private double sourceBaseYearPlus2; // 2018
	private double sourceBaseYearPlus3; // 2019
	private double sumSources123;
	
	private List<Double> rebalanceOneFieldDoubleList = new ArrayList<>();

	public DtoProgrammeFinancialSourceItem() {}
	
	// DtoProgrammeFinancialSource
	public void sumDtoProgrammeItemFinancialSources(DtoProgrammeFinancialSource dtoFinance) {
		this.setSourceBaseYear(this.getSourceBaseYear() + dtoFinance.getSourceBaseYear());
		this.setSourceBaseYearPlus1(this.getSourceBaseYearPlus1() + dtoFinance.getSourceBaseYearPlus1());
		this.setSourceBaseYearPlus2(this.getSourceBaseYearPlus2() + dtoFinance.getSourceBaseYearPlus2());
		this.setSourceBaseYearPlus3(this.getSourceBaseYearPlus3() + dtoFinance.getSourceBaseYearPlus3());
		this.setSumSources123(this.getSumSources123() + dtoFinance.getSumSources123());
		plusRebBudget(dtoFinance.getListSourceRebalance());
	}

	// List<Double> rebalanceOneFieldDoubleList + List<Double> rebalanceOneFieldDoubleList
	public void plusRebBudget(List<Double> list) {
		for (int i = 0; i < this.getRebalanceOneFieldDoubleList().size(); i++) {
			double d = this.getRebalanceOneFieldDoubleList().get(i) + list.get(i);
			this.getRebalanceOneFieldDoubleList().set(i, d);
		}
	}

}

