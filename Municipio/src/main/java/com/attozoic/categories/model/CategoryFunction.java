package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_functions")
@Data
public class CategoryFunction {

	@Id
	@GeneratedValue
	private Long uid;
	private String code; // 010
	private String name; // Болест и инвалидност
	
	public CategoryFunction(){}
	
	public CategoryFunction(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
}
