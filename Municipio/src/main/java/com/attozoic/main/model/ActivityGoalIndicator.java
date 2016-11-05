package com.attozoic.main.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activity_goal_indicators")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "uid")
public class ActivityGoalIndicator extends SuperEntity {

	private Long categoryID;
	
	private String name;
	
    @ManyToOne
	@JoinColumn(name="activityGoal_uid")
	//@JsonBackReference
    private ActivityGoal activityGoal;
    
	private String valueBase; // 2016
	private String targetValuePlus1; // 2017
	private String targetValuePlus2; // 2018
	private String targetValuePlus3; // 2019
	
	private String verificationSource;

	@ElementCollection
	@CollectionTable(name = "activityGoalIndicator_rebalances", joinColumns = @JoinColumn(name = "rebalance_uid"))
	private List<RebalanceOneField> rebalances = new ArrayList<>();
	
	public ActivityGoalIndicator() {}
	
}
