package com.attozoic.categories.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_functions")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryFunction extends CategorySuperEntity {

	private String code; // 010
	@Column(length = 256)
	private String name; // Болест и инвалидност
	
	public CategoryFunction() {}
	
}
