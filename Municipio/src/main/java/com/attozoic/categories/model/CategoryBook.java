package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_books")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryBook extends CategorySuperEntity {
	
	private String code;
	private String name;
	
	public CategoryBook() {}

}
