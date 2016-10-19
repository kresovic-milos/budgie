package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_financial_sources")
@Data
public class CategoryFinancialSource {

	@Id
	@GeneratedValue
	private Long uid;
	private String code; // 01
	private String name; // Приходи из буџета
	
	public CategoryFinancialSource() {}
	
	public CategoryFinancialSource(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
}
