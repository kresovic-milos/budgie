package com.attozoic.main.model.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class DtoSuperEA implements Comparable<DtoSuperEA> {

	private String code;
	private String name;
	private List<Double> balances = new ArrayList<>();
	
	public DtoSuperEA() {
		this.balances.add(new Double(0));
		this.balances.add(new Double(0));
	}
	
	public DtoSuperEA(String name, String code, List<Double> balances) {
		this.name = name;
		this.code = code;
		this.balances = balances;
	}
	
//	public DtoSuperEA sum(DtoSuperEA d) {
//		DtoSuperEA dto = new DtoSuperEA();
//		List<Double> list = new ArrayList<>();
//		list.add(this.balances.get(0) + d.balances.get(0));
//		list.add(this.balances.get(1) + d.balances.get(1));
//		dto.setBalances(list);
//		return dto;
//	}

	@Override
	public int compareTo(DtoSuperEA o) {
		return Integer.parseInt(this.getCode()) - Integer.parseInt(o.getCode());
	}
	
}
