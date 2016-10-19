package com.attozoic.categories.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_activities")
@Data
public class CategoryActivity {
	
	@Id
	@GeneratedValue
	private Long uid;
	private String code; // 1101-0001
	private String ordNumber; // ПА_1
	private String name; // Стратешко, просторно и урбанистичко планирање
	
	public CategoryActivity() {}
	
	public CategoryActivity(String code, String ordNumber, String name) {
		this.code = code;
		this.ordNumber = ordNumber;
		this.name = name;
	}

}
