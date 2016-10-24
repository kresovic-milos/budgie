package com.attozoic.main.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="project_goal_indicators")
@Data
@EqualsAndHashCode(callSuper=true)
public class ProjectGoalIndicator extends SuperEntity {

	private String name;
	
    @ManyToOne
	@JoinColumn(name="projectGoal_uid")
	@JsonBackReference
    private ProjectGoal projectGoal;
    
	private long valueBase; // 2016
	private long targetValuePlus1; // 2017
	private long targetValuePlus1Rebalance1;
	private long targetValuePlus1Rebalance2;
	private long targetValuePlus1Rebalance3;
	private long targetValuePlus1Rebalance4;
	private long targetValuePlus2; // 2018
	private long targetValuePlus3; // 2019
	private long verificationSource;
	
	public ProjectGoalIndicator() {}

	public ProjectGoalIndicator(String name, long valueBase, long targetValuePlus1, long targetValuePlus1Rebalance1,
			long targetValuePlus1Rebalance2, long targetValuePlus1Rebalance3, long targetValuePlus1Rebalance4,
			long targetValuePlus2, long targetValuePlus3, long verificationSource) {
		super();
		this.name = name;
		this.valueBase = valueBase;
		this.targetValuePlus1 = targetValuePlus1;
		this.targetValuePlus1Rebalance1 = targetValuePlus1Rebalance1;
		this.targetValuePlus1Rebalance2 = targetValuePlus1Rebalance2;
		this.targetValuePlus1Rebalance3 = targetValuePlus1Rebalance3;
		this.targetValuePlus1Rebalance4 = targetValuePlus1Rebalance4;
		this.targetValuePlus2 = targetValuePlus2;
		this.targetValuePlus3 = targetValuePlus3;
		this.verificationSource = verificationSource;
	}

	


	
}
