package com.attozoic.main.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class RebalanceOneField {

	private double value1;
	private double value2;
	private double value3;
	private double value4;
	
	public RebalanceOneField() {
		this.value1 = 17;
	}
	
}
