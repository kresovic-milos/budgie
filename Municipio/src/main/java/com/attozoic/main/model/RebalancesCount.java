package com.attozoic.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "rebalances_count")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=RebalancesCount.class)
public class RebalancesCount extends SuperEntity {
	
	@Column(name = "rebalance_count", nullable = false)
	private int rebalancesCount = 0;
	
	public RebalancesCount() {}

}
