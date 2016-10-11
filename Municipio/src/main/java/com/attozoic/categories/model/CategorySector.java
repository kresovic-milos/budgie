package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_sector")
@Data
public class CategorySector {

	@Id
	@GeneratedValue
	private Long uid;
	private String name; //Сектор_1__Пољопривреда_и_рурални_развој
	
	public CategorySector() {
	}
	
	public CategorySector(String name) {
		this.name = name;
	}

	
}
