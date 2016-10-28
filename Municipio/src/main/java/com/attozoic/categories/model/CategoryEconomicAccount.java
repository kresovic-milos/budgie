package com.attozoic.categories.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_economic_accounts")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryEconomicAccount extends CategorySuperEntity {

	@Id
	@GeneratedValue
	private Long uid;
	private String code; // 400000
	@Column(length = 512)
	private String name; // Текући расходи
	
	public CategoryEconomicAccount() {}
	
	public CategoryEconomicAccount(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
}
