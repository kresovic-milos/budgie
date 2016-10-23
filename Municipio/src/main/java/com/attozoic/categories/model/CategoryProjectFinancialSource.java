package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_project_financial_sources")
@Data
public class CategoryProjectFinancialSource {

	@Id
	@GeneratedValue
	private Long uid;
	private String code; // 01
	private String name; // Приходи из буџета
	
	public CategoryProjectFinancialSource() {}
	
	public CategoryProjectFinancialSource(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
}
