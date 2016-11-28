package com.attozoic.main.model.dto;

import lombok.Data;

@Data
public class DtoProgrammeChartObject {

	private String name;
	private double value;
	private double percnetage = 0;

	public DtoProgrammeChartObject() {}
	
	public DtoProgrammeChartObject(String name, double value, double percentage) {
		this.name = name;
		this.value = value;
		this.percnetage = percentage;
	}
	
}
