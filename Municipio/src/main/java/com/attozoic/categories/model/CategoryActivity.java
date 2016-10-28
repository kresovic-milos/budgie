package com.attozoic.categories.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "category_activities")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryActivity extends CategorySuperEntity {
	
	@Id
	@GeneratedValue
	private Long uid;
	private String code; // 1101-0001
	private String ordNumber; // ПА_1
	@Column(length = 512)
	private String name; // Стратешко, просторно и урбанистичко планирање
	
	private Long categoryProgrammeID;
	
	@ManyToOne
	@JoinColumn(name="programme_uid")
	@JsonBackReference
	private CategoryProgramme categoryProgramme;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="categoryActivity")
	@JsonManagedReference
	private List<CategoryActivityGoal> categoryActivityGoals;
	
//    @ManyToMany
//    @JoinTable(
//    		name="categoryActivity_categoryFinance",
//    		joinColumns={@JoinColumn(name="categoryActivity_id")},
//    		inverseJoinColumns={@JoinColumn(name="categoryFinancialSource_id")}
//    		)
//    private List<CategoryFinancialSource> categoryActivityFinancialSources = new ArrayList<>();
	
	public CategoryActivity() {}
	
	public CategoryActivity(String code, String ordNumber, String name) {
		this.code = code;
		this.ordNumber = ordNumber;
		this.name = name;
	}

}
