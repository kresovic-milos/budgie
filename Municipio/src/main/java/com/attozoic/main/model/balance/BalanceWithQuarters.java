package com.attozoic.main.model.balance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.attozoic.main.model.RebalancesCount;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "balance_with_quarters")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=RebalancesCount.class)
@JsonTypeName("balanceWithQuarters")
public class BalanceWithQuarters extends BalanceEconomicAccount {
	
	@ElementCollection
	@CollectionTable(name = "balanceWithQuarters_values", joinColumns = @JoinColumn(name = "balanceWithQuarters_id"))
	@OrderColumn
	private List<Double> values = new ArrayList<>(4);
	
	private double sumQuarters = sumQuarters(); 
	
	public BalanceWithQuarters() {
		values.add(new Double(0));
		values.add(new Double(0));
		values.add(new Double(0));
		values.add(new Double(0));
	}
	
	public double sumQuarters() {
		double sum = 0;
		for (Double d : this.values) {
			sum += d;
		} 
		return sum;
	}

	@Override
	public void sumBalances(BalanceEconomicAccount balance) {
		for(int i = 0; i < values.size(); i++) {
			this.values.set(i, this.values.get(i) + ((BalanceWithQuarters)balance).getValues().get(i));
		}
		
		//this.setSumQuarters(this.getSumQuarters() + ((BalanceWithQuarters)balance).getSumQuarters());
	}
	
}
