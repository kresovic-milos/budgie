package com.attozoic.main.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class DtoChartProgrammes {

	private double sum;
	private List<DtoChartProgramme> list = new ArrayList<>();
	
	public DtoChartProgrammes() {}
	
}
