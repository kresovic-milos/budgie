package com.attozoic.main.model.balance;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.attozoic.main.model.RebalancesCount;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "balance_numeric")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=RebalancesCount.class)
@JsonTypeName("balanceNumeric")
public class BalanceNumeric extends BalanceEconomicAccount {

	private double value = 0;
	
	public BalanceNumeric() {}
	
	public void sumBalances(BalanceNumeric balanceNumeric) {
		this.setValue(this.getValue() + balanceNumeric.getValue());
	}

	@Override
	public void sumBalances(BalanceEconomicAccount balance) {
		this.setValue(this.getValue() + ((BalanceNumeric)balance).getValue());
	}
	
}
