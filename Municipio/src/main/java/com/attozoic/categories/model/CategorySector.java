package com.attozoic.categories.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "category_sector")
@Data
public class CategorySector {

	@Id
	@GeneratedValue
	private Long uid;
	private String name; //Сектор_1__Пољопривреда_и_рурални_развој
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="categorySector")
	@JsonManagedReference
	private List<CategoryProgramme> categoryProgrammes;
	
	public CategorySector() {
	}
	
	public CategorySector(String name) {
		this.name = name;
	}

	
}
