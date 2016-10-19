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

import com.attozoic.categories.model.CategoryProgramme;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="programme_goals")
@Data
public class ProgrammeGoal {

	@Id
	@GeneratedValue
	private Long uid;
	
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    // @JoinColumn(name="USER_ID", nullable=false)
    @PrimaryKeyJoinColumn
	private CategoryProgramme categoryProgramme;
	
    @ManyToOne
	@JoinColumn(name="programme_uid")
	@JsonBackReference
    private Programme programme;
    
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="programmeGoal")
	@JsonManagedReference
    private List<ProgrammeGoalIndicator> programmeGoalIndicators;
	
	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;
	
	public ProgrammeGoal() {}

	public ProgrammeGoal(CategoryProgramme categoryProgramme) {
		this.categoryProgramme = categoryProgramme;
	}
	
}
