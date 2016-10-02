package com.attozoic.categories.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Table(name = "category_sector")
@Data
public class CategorySector {

	@Id
	@GeneratedValue
	private Long uid;
	
	private String name;
	
	@OneToMany(mappedBy="sector")
	private List<CategoryProgramme> programmes;
	
	/*CONSTRUCTORS*/
	
	public CategorySector() {
	}
	
	public CategorySector(String name, List<CategoryProgramme> programmes) {
		this.name = name;
		this.programmes = programmes;
	}
	
}
