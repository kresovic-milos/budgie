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
@Table(name = "category_activities")
@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryActivity extends CategorySuperEntity {

	private String code; // 1101-0001
	private String ordNumber; // ПА_1
	@Column(length = 512)
	private String name; // Стратешко, просторно и урбанистичко планирање
	
	@Transient
	private Long categoryProgrammeID;
	
	@ManyToOne
	@JoinColumn(name="programme_uid")
	@JsonBackReference
	private CategoryProgramme categoryProgramme;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="categoryActivity")
	@JsonManagedReference
	private List<CategoryActivityGoal> categoryActivityGoals;
	
	public CategoryActivity() {}

}
