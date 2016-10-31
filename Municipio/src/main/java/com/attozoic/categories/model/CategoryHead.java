package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_heads")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryHead extends CategorySuperEntity {

	private String code;
	private String name;
	
	public CategoryHead() {}
	
	public CategoryHead(String code, String name){
		this.code = code;
		this.name = name;
	}
	
}
