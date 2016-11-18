package com.attozoic.main.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class DtoProgrammeChart {

	private double budgetValue;
	private List<DtoProgrammeChartObject> list = new ArrayList<>();
	
	public DtoProgrammeChart() {}

	public DtoProgrammeChart(double budgetValue, List<DtoProgrammeChartObject> list) {
		this.budgetValue = budgetValue;
		this.list = list;
	}
	
}
