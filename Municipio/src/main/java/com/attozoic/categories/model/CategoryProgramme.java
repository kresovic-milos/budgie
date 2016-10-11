package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_programme")
@Data
public class CategoryProgramme {

	@Id
	@GeneratedValue
	private Long uid;
	private String code; // 1101
	private String ordNumber; // ПГ_1
	private String name; // Програм_1__Локални_развој_и_просторно_планирање
	private String purpose; // Планско одређивање праваца развоја локалне средине и ефикасно администрирање захтева за издавање грађевинских дозвола
	
	public CategoryProgramme() {
	}

	public CategoryProgramme(String code, String ordNumber, String name, String purpose) {
		this.code = code;
		this.ordNumber = ordNumber;
		this.name = name;
		this.purpose = purpose;
	}
	
	
	
}
