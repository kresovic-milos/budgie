package com.attozoic.main.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class RebalanceOneField {

	private double value1;
	
	public RebalanceOneField() {
		this.value1 = 17;
	}
}
