package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_programme")
@Data
public class CategoryProgramme {

	@Id
	@GeneratedValue
	private Long uid;
	
	private String code;
	
	private String ordNumber;
	
	private String name;
	
	private String purpose;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sector")
	private CategorySector sector;

	public CategoryProgramme(String code, String ordNumber, String name, String purpose) {
		this.code = code;
		this.ordNumber = ordNumber;
		this.name = name;
		this.purpose = purpose;
	}
	
}
