package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_economic_accounts")
@Data
public class CategoryEconomicAccount {

	@Id
	@GeneratedValue
	private Long uid;
	private String code; // 400000
	private String name; // Текући расходи
	
	public CategoryEconomicAccount() {}
	
	public CategoryEconomicAccount(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
}
