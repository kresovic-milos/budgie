package com.attozoic.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name="project_goal_indicators")
@Data
public class ProjectGoalIndicator {

	@Id
	@GeneratedValue
	private Long uid;
	
//    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
//    @PrimaryKeyJoinColumn
//	private CategoryActivityGoalIndicator categoryActivityGoalIndicator;
	
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

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "create_date")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "update_date")
	private Date updateDate;
	
	public ProjectGoalIndicator() {}

	public ProjectGoalIndicator(long valueBase, long targetValuePlus1, long targetValuePlus1Rebalance1,
			long targetValuePlus1Rebalance2, long targetValuePlus1Rebalance3, long targetValuePlus1Rebalance4,
			long targetValuePlus2, long targetValuePlus3, long verificationSource) {
		super();
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
