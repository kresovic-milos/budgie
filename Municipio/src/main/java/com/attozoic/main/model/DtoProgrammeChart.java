package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class DtoProgrammeChart {

	private double sum;
	private List<DtoProgrammeChartObject> list = new ArrayList<>();
	
	public DtoProgrammeChart() {}
	
}
