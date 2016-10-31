package com.attozoic.categories.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_programmes")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryProgramme extends CategorySuperEntity {

	private String code; // 1101
	private String ordNumber; // ПГ_1
	@Column(length = 512)
	private String name; // Програм_1__Локални_развој_и_просторно_планирање
	@Column(length = 2048)
	private String purpose; // Планско одређивање праваца развоја локалне средине и ефикасно администрирање захтева за издавање грађевинских дозвола
	
	@Transient
	private Long categorySectorID;
	
	@ManyToOne
	@JoinColumn(name="categorySector_uid")
	@JsonBackReference
	private CategorySector categorySector;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="categoryProgramme")
	@JsonManagedReference
	private List<CategoryProgrammeGoal> categoryProgrammeGoals;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="categoryProgramme")
	@JsonManagedReference	
	private List<CategoryActivity> acivities;

	public CategoryProgramme() {
	}

	public CategoryProgramme(String code, String ordNumber, String name, String purpose) {
		this.code = code;
		this.ordNumber = ordNumber;
		this.name = name;
		this.purpose = purpose;
	}	
	
}
