package com.attozoic.main.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class DtoFunction2 implements Comparable<DtoFunction2> {

	private String code;
	private String name;
	private List<Double> amounts;
	
	public DtoFunction2() {}
	
	public DtoFunction2(String code, String name, List<Double> amounts) {
		this.name = name;
		this.code = code;
		this.amounts = amounts;
	}

	@Override
	public int compareTo(DtoFunction2 o) {
		return Integer.parseInt(this.getCode()) - Integer.parseInt(o.getCode());
	}
	
}
