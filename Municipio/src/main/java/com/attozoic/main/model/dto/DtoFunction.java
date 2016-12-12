package com.attozoic.main.model.dto;

import lombok.Data;

@Data
public class DtoFunction implements Comparable<DtoFunction> {

	private String name;
	private double amount;
	
	public DtoFunction() {}
	
	public DtoFunction(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}

	@Override
	public int compareTo(DtoFunction o) {
		return Integer.parseInt(this.name.substring(0, 3)) - Integer.parseInt(o.name.substring(0, 3));
	}
	
}
