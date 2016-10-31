package com.attozoic.categories.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_sectors")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategorySector extends CategorySuperEntity {

	@Column(length = 512)
	private String name; //Сектор_1__Пољопривреда_и_рурални_развој
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="categorySector")
	@JsonManagedReference
	private List<CategoryProgramme> categoryProgrammes;
	
	public CategorySector() {
	}
	
	public CategorySector(String name) {
		this.name = name;
	}
	
}
