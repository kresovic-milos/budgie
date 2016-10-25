package com.attozoic.main.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activity_goals")
@Data
@EqualsAndHashCode(callSuper=true)
public class ActivityGoal extends SuperEntity {
	
	private String code;
	private String name;

    @ManyToOne
	@JoinColumn(name="activity_uid")
	@JsonBackReference
    private Activity activity;
    
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="activityGoal")
	@JsonManagedReference
    private List<ActivityGoalIndicator> activityGoalIndicators;
	
    public ActivityGoal() {}

	public ActivityGoal(String code, String name) {
		this.code = code;
		this.name = name;
	}
    
}
