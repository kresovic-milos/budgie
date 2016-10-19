package com.attozoic.main.model;

import java.sql.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.attozoic.categories.model.CategoryActivity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="activities")
@Data
public class Activity {

	@Id
	@GeneratedValue
	private Long uid;
	
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @PrimaryKeyJoinColumn
	private CategoryActivity categoryActivity;    
    
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activity")
	@JsonManagedReference
    private List<ActivityGoal> activityGoals;
	
    @ManyToOne
	@JoinColumn(name="programme_uid")
	@JsonBackReference
    private Programme programme;
	
    @ManyToOne
    @JoinColumn(name="function_id")
    @JsonBackReference
    private Function function;
    
    private String budgetUser;
	private String rudiment;
	private String description;
	private String anex;
	private String responsibleAuthority;
	
	private Long sumExpenses;
	private Long sumFinancialSources;
	
	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;
	
	public Activity() {}

	public Activity(CategoryActivity categoryActivity, String budgetUser, String rudiment, String description,
			String anex, String responsibleAuthority, Long sumExpenses, Long sumFinancialSources) {
		this.categoryActivity = categoryActivity;
		this.budgetUser = budgetUser;
		this.rudiment = rudiment;
		this.description = description;
		this.anex = anex;
		this.responsibleAuthority = responsibleAuthority;
		this.sumExpenses = sumExpenses;
		this.sumFinancialSources = sumFinancialSources;
	}
    
}
