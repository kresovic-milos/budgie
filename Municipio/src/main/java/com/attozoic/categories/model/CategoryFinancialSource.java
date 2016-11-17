package com.attozoic.categories.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_activity_financial_sources")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryFinancialSource extends CategorySuperEntity {

	private String code; // 01
	@Column(length = 256)
	private String name; // Приходи из буџета

	public CategoryFinancialSource() {}
	
}
