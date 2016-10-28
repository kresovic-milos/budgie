package com.attozoic.categories.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_activity_financial_sources")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryFinancialSource extends CategorySuperEntity {

	@Id
	@GeneratedValue
	private Long uid;
	private String code; // 01
	@Column(length = 256)
	private String name; // Приходи из буџета
	
//    @ManyToMany(cascade=CascadeType.ALL, mappedBy="categoryProgrammeFinancialSources")
//    @JsonIgnore
//    private List<CategoryProgramme> categoryProgrammes = new ArrayList<>();
//    
//    @ManyToMany(cascade=CascadeType.ALL, mappedBy="categoryActivityFinancialSources")
//    @JsonIgnore
//    private List<CategoryActivity> categoryActivities = new ArrayList<>();
	
	public CategoryFinancialSource() {}
	
	public CategoryFinancialSource(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
}
