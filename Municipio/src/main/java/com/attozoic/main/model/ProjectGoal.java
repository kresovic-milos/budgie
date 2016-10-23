package com.attozoic.main.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="project_goals")
@Data
public class ProjectGoal {

	@Id
	@GeneratedValue
	private Long uid;
	private String name;
	
//    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
//    //@JoinColumn(name="USER_ID", nullable=false)
//    @PrimaryKeyJoinColumn
//	private CategoryActivityGoal categoryActivityGoal;
	
    @ManyToOne
	@JoinColumn(name="project_uid")
	@JsonBackReference
    private Project project;
    
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="projectGoal")
	@JsonManagedReference
    private List<ProjectGoalIndicator> projectGoalIndicators;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;
	
    public ProjectGoal() {}

	public ProjectGoal(String name) {
		this.name = name;
	}
    

    
}
