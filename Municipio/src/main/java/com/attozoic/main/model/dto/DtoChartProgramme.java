package com.attozoic.main.model.dto;

import lombok.Data;

@Data
public class DtoChartProgramme {

	private String name;
	private double value;
	private double percnetage = 0;

	public DtoChartProgramme() {}
	
	public DtoChartProgramme(String name, double value, double percentage) {
		this.name = name;
		this.value = value;
		this.percnetage = percentage;
	}
}
