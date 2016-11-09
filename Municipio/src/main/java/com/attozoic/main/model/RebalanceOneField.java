package com.attozoic.main.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class RebalanceOneField {

	private double value = 0;
	
	public RebalanceOneField() {
		this.value = 0;
	}
	
}
