package com.attozoic.categories.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name = "category_programmes")
@Data
public class CategoryProgramme {

	@Id
	@GeneratedValue
	private Long uid;
	private String code; // 1101
	private String ordNumber; // ПГ_1
	private String name; // Програм_1__Локални_развој_и_просторно_планирање
	private String purpose; // Планско одређивање праваца развоја локалне средине и ефикасно администрирање захтева за издавање грађевинских дозвола
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="categoryProgramme")
	@JsonManagedReference
	private List<CategoryProgrammeGoal> categoryProgrammeGoals;
	
	@ManyToOne
	@JoinColumn(name="categorySector_uid")
	@JsonBackReference
	private CategorySector categorySector;
	
	public CategoryProgramme() {
	}

	public CategoryProgramme(String code, String ordNumber, String name, String purpose) {
		this.code = code;
		this.ordNumber = ordNumber;
		this.name = name;
		this.purpose = purpose;
	}
	
	
	
}
