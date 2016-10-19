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

import com.attozoic.categories.model.CategoryActivityGoal;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Table(name="activity_goals")
@Data
public class ActivityGoal {

	@Id
	@GeneratedValue
	private Long uid;
	
    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    // @JoinColumn(name="USER_ID", nullable=false)
    @PrimaryKeyJoinColumn
	private CategoryActivityGoal categoryActivityGoal;
	
    @ManyToOne
	@JoinColumn(name="activity_uid")
	@JsonBackReference
    private Activity activity;
    
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="activityGoal")
	@JsonManagedReference
    private List<ActivityGoalIndicator> activityGoalIndicators;
	
	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;
	
    public ActivityGoal() {}
    
    public ActivityGoal(CategoryActivityGoal categoryActivityGoal) {
    	this.categoryActivityGoal = categoryActivityGoal;
    }
    
}
