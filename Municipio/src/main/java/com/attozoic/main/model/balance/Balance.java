package com.attozoic.main.model.balance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.ActiveState;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.SuperFinancialSource;
import com.attozoic.main.model.dto.DtoFinancialSource;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "balances")
//@Data
//@EqualsAndHashCode(callSuper=true)
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=Balance.class)
public class Balance extends SuperEntity implements Comparable<Balance> {
	
	private BalanceType balanceType;
	private double year;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="economicAccount_uid")
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnoreProperties({"balances", "activity", "project", "categoryID", "code", "categoryName", "name", "poz", "sumExpenses123Budget", "sumExpenses123Others"})
	private SuperEconomicAccount superEconomicAccount;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="balance")
	@JsonIgnore
	private List<SuperFinancialSource> financialSources = new ArrayList<>();
	
	private double balance_amount;
	
	public Balance() {}

	public Balance(BalanceType balanceType, double year, SuperEconomicAccount superEconomicAccount) {
		this.balanceType = balanceType;
		this.year = year;
		this.superEconomicAccount = superEconomicAccount;
		this.generateBalanceAmount();
	}
		
	public void generateBalanceAmount() {
		double sum = 0;
		for (SuperFinancialSource superFinancialSource : financialSources) {
			if (superFinancialSource.getActiveState() == ActiveState.ACTIVE) {
				sum += superFinancialSource.getAmount();
			}
		}
		this.setBalance_amount(sum);
	}

	public Balance sumBalancesSameYearAndType(Balance balance) {
		Balance balance1 = new Balance();
		balance1.setBalanceType(this.getBalanceType());
		balance1.setYear(this.getYear());
		balance1.setBalance_amount(this.getBalance_amount() + balance.getBalance_amount());
		return balance1;
	}
	
	public List<DtoFinancialSource> generateDtoFinancialSourceList() {
		List<DtoFinancialSource> list = new ArrayList<>();
		for (SuperFinancialSource superFinancialSource : financialSources) {
			if (superFinancialSource.getActiveState() == ActiveState.ACTIVE) {
				list.add(superFinancialSource.generateDtoFinancialSource());
			}
		}
		return list;
	}

	@Override
	public int compareTo(Balance o) {
		if (this.getYear() < o.getYear()) {
			return -1;
		} else if (this.getYear() > o.getYear()) {
			return 1;
		} else {
			if (this.getBalanceType() == BalanceType.BUDGET) {
				return -1;
			} else {
				return 1;
			}
		}
		
	}
	
}
