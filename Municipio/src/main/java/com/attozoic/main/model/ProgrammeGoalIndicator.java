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
@Table(name="programme_goal_indicators")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid")
public class ProgrammeGoalIndicator extends SuperEntity {

	private Long categoryID;
	
	private String name;
	
    @ManyToOne
	@JoinColumn(name="programmeGoal_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private ProgrammeGoal programmeGoal;
    
	private String valueBase; // 2016
	private String targetValuePlus1; // 2017
	private String targetValuePlus2; // 2018
	private String targetValuePlus3; // 2019
	
	private String verificationSource;
	
	@ElementCollection
	@CollectionTable(name = "programmeGoalIndicator_rebalances", joinColumns = @JoinColumn(name = "rebalance_uid"))
	@OrderColumn
	private List<RebalanceOneField> rebalances = new ArrayList<>();  
	
	public ProgrammeGoalIndicator() {}

	public ProgrammeGoalIndicator(Long categoryID, String name, String valueBase, String targetValuePlus1,
			String targetValuePlus2, String targetValuePlus3, String verificationSource,
			List<RebalanceOneField> rebalances) {
		super();
		this.categoryID = categoryID;
		this.name = name;
		this.valueBase = valueBase;
		this.targetValuePlus1 = targetValuePlus1;
		this.targetValuePlus2 = targetValuePlus2;
		this.targetValuePlus3 = targetValuePlus3;
		this.verificationSource = verificationSource;
		this.rebalances = rebalances;
	}
	
	
	
}
