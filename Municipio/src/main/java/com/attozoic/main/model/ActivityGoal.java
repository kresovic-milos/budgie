package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activity_goals")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ActivityGoal.class)
public class ActivityGoal extends SuperEntity {
	
	private Long categoryID;
	
	private String code;
	private String name;

    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activity_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private Activity activity;
    
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activityGoal")
    private List<ActivityGoalIndicator> activityGoalIndicators = new ArrayList<>();
	
    public ActivityGoal() {}

}
