package com.attozoic.main.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class RebalanceTwoFields {

	private double value1;
	private double value2;
	
	public RebalanceTwoFields() {
		this.value1 = 0;
		this.value1 = 0;
	}
}
