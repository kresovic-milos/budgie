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
	private long targetValuePlus2; // 2018
	private long targetValuePlus3; // 2019
	private long verificationSource;
	
	@ElementCollection
	@CollectionTable(name = "indicator_rebalances", joinColumns = @JoinColumn(name = "rebalance_uid"))
	private List<Double> rebalances; 
	
	public ProjectGoalIndicator() {}

	public ProjectGoalIndicator(String name, long valueBase, long targetValuePlus1, 
			long targetValuePlus2, long targetValuePlus3, long verificationSource) {
		super();
		this.name = name;
		this.valueBase = valueBase;
		this.targetValuePlus1 = targetValuePlus1;
		this.targetValuePlus2 = targetValuePlus2;
		this.targetValuePlus3 = targetValuePlus3;
		this.verificationSource = verificationSource;
		this.rebalances = new ArrayList<>();
	}

	


	
}
