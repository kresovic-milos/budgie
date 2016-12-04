package com.attozoic.main.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class DtoProgrammeFinances {

	List<Map.Entry<String, double[]>> list;
	//Map<String, double[]> map; // Izvori Finansiranja Programa
	private String name; // Naziv programa
	private double[] amounts; // Red UKUPNO - Sume izvora
 	
	public DtoProgrammeFinances() {}
	
	public DtoProgrammeFinances(ArrayList<Map.Entry<String, double[]>> list, String name, double[] amounts) {
		this.list = list;
		this.name = name;
		this.amounts = amounts;
	}
	
}
