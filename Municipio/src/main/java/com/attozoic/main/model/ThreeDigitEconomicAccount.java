package com.attozoic.main.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="three_digit_economic_accounts")
@Data
@EqualsAndHashCode(callSuper=true)
public class ThreeDigitEconomicAccount extends SuperEntity {

	private String code;
	private String poz;
	private String type; // activity / project
	private Long itemUid;
	
	public ThreeDigitEconomicAccount() {}
	
	public ThreeDigitEconomicAccount(String code, String poz, String type, Long itemUid) {
		this.code = code;
		this.poz = poz;
		this.type = type;
		this.itemUid = itemUid;
	}
	
}
