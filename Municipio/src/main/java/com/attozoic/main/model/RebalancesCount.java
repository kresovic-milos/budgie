package com.attozoic.main.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "rebalances_count")
@Data
@EqualsAndHashCode(callSuper=true)
public class RebalancesCount extends SuperEntity {
	
	private int rebalancesCount = 0;
	
	public RebalancesCount() {}
	
	public RebalancesCount(int rebalancesCount) {
		this.rebalancesCount = rebalancesCount;
	}
	
}