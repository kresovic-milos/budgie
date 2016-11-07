package com.attozoic.main.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class RebalanceOneField {

	private double value;
	
	public RebalanceOneField() {
		this.value = 0;
	}
	
}
