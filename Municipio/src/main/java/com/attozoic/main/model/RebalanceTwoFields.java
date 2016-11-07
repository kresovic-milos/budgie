package com.attozoic.main.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class RebalanceTwoFields {

	private double valueB1;
	private double valueB2;
	private double valueB3;
	private double valueB4;
	
	private double sumValueB;
	
	private String financialSourceValueBudget;
	
	private double valueO1;
	private double valueO2;
	private double valueO3;
	private double valueO4;
	
	private double sumValueO;
	
	private String financialSourceValueOthers;
	
	public RebalanceTwoFields() {
		this.valueB1 = 0;
		this.valueB2 = 0;
		this.valueB3 = 0;
		this.valueB4 = 0;
		this.setSumValueB(this.getValueB1() + this.getValueB2() + this.getValueB3() + this.getValueB4());
		this.financialSourceValueBudget = "";
		this.valueO1 = 0;
		this.valueO2 = 0;
		this.valueO3 = 0;
		this.valueO4 = 0;
		this.setSumValueO(this.getValueO1() + this.getValueO2() + this.getValueO3() + this.getValueO4());
		this.financialSourceValueOthers = "";
	}
}
