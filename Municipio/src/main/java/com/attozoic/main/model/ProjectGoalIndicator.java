package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="project_goal_indicators")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid")
public class ProjectGoalIndicator extends SuperEntity {

	private String name;
	
	private String valueBase; // 2016
	private String targetValuePlus1; // 2017
	private String targetValuePlus2; // 2018
	private String targetValuePlus3; // 2019
	
	private String verificationSource;

    @ManyToOne
	@JoinColumn(name="projectGoal_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private ProjectGoal projectGoal;
	
	@ElementCollection
	@CollectionTable(name = "projectGoalIndicator_rebalances", joinColumns = @JoinColumn(name = "rebalance_uid"))
	@OrderColumn
	private List<RebalanceOneField> rebalances = new ArrayList<>(); 
	
	public ProjectGoalIndicator() {}
	
}
