package com.attozoic.main.model;

import lombok.Data;

@Data
public class DtoRebalanceTwoFields {
	
	private double valueB1;
	private double valueB2;
	private double valueB3;
	private double valueB4;
	
	private double sumValueB;
	
	private double valueO1;
	private double valueO2;
	private double valueO3;
	private double valueO4;
	
	private double sumValueO;
	
	public DtoRebalanceTwoFields() {}

	public DtoRebalanceTwoFields(double valueB1, double valueB2, double valueB3, double valueB4,
			double sumValueB, double valueO1, double valueO2, double valueO3, double valueO4, double sumValueO) {
		super();
		this.valueB1 = valueB1;
		this.valueB2 = valueB2;
		this.valueB3 = valueB3;
		this.valueB4 = valueB4;
		this.sumValueB = sumValueB;
		this.valueO1 = valueO1;
		this.valueO2 = valueO2;
		this.valueO3 = valueO3;
		this.valueO4 = valueO4;
		this.sumValueO = sumValueO;
	}
	
	public double sumValueBudget() {
		return this.valueB1 + this.valueB2 + this.valueB3 + this.valueB4;
	}
	
	public double sumValueOthers() {
		return this.valueO1 + this.valueO2 + this.valueO3 + this.valueO4;
	}
	
	public void sum(DtoRebalanceTwoFields dto) {
		this.setValueB1(this.getValueB1() + dto.getValueB1());
		this.setValueB2(this.getValueB2() + dto.getValueB2());
		this.setValueB3(this.getValueB3() + dto.getValueB3());
		this.setValueB4(this.getValueB4() + dto.getValueB4());
		this.setSumValueB(this.getSumValueB() + dto.getSumValueB());
		this.setValueO1(this.getValueO1() + dto.getValueO1());
		this.setValueO2(this.getValueO2() + dto.getValueO2());
		this.setValueO3(this.getValueO3() + dto.getValueO3());
		this.setValueO4(this.getValueO4() + dto.getValueO4());
		this.setSumValueO(this.getSumValueO() + dto.getSumValueO());
	}
}
