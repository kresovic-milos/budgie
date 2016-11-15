package com.attozoic.main.model.balance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.ActivityFinancialSource;
import com.attozoic.main.model.ProjectFinancialSource;
import com.attozoic.main.model.SuperEconomicAccount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.SuperFinancialSource;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "balances")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=Balance.class)
public class Balance extends SuperEntity {
	
	private BalanceType balanceType;
	private double year;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="economicAccount_uid")
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonIgnoreProperties({"balances", "activity", "project", "categoryID", "code", "categoryName", "name", "poz", "sumExpenses123Budget", "sumExpenses123Others"})
	private SuperEconomicAccount superEconomicAccount;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="balance_q1")
	private List<SuperFinancialSource> quarter1 = new ArrayList<>();
	
	private double quarter1_amount = 0;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="balance_q2")
	private List<SuperFinancialSource> quarter2 = new ArrayList<>();
	
	private double quarter2_amount = 0;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="balance_q3")
	private List<SuperFinancialSource> quarter3 = new ArrayList<>();
	
	private double quarter3_amount = 0;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="balance_q4")
	private List<SuperFinancialSource> quarter4 = new ArrayList<>();
	
	private double quarter4_amount = 0;
	
	private double balance_amount = 0;
	
	public Balance() {}

	public Balance(BalanceType balanceType, double year, SuperEconomicAccount superEconomicAccount) {
		this.balanceType = balanceType;
		this.year = year;
		this.superEconomicAccount = superEconomicAccount;
		this.quarter1_amount = generateQuarterAmountValue(quarter1);
		this.quarter2_amount = generateQuarterAmountValue(quarter2);
		this.quarter3_amount = generateQuarterAmountValue(quarter3);
		this.quarter4_amount = generateQuarterAmountValue(quarter4);
		this.balance_amount = generateAmountValue();
	}
	
	public double generateQuarterAmountValue(List<SuperFinancialSource> quarter) {
		double amount = 0;
		for (SuperFinancialSource superFinancialSource : quarter) {
			amount += superFinancialSource.getAmount();
		}
		return amount;
	}
	//
	public void generateQuarter1AmountValue() {
		this.setQuarter1_amount(0);
		for (SuperFinancialSource superFinancialSource : quarter1) {
			this.setQuarter1_amount(this.getQuarter1_amount() + superFinancialSource.getAmount());
		}
	}
	//
	public void generateQuarter2AmountValue() {
		this.setQuarter2_amount(0);
		for (SuperFinancialSource superFinancialSource : quarter2) {
			this.setQuarter2_amount(this.getQuarter2_amount() + superFinancialSource.getAmount());
		}
	}
	public void generateQuarter3AmountValue() {
		this.setQuarter3_amount(0);
		for (SuperFinancialSource superFinancialSource : quarter3) {
			this.setQuarter3_amount(this.getQuarter3_amount() + superFinancialSource.getAmount());
		}
	}
	public void generateQuarter4AmountValue() {
		this.setQuarter4_amount(0);
		for (SuperFinancialSource superFinancialSource : quarter4) {
			this.setQuarter4_amount(this.getQuarter4_amount() + superFinancialSource.getAmount());
		}
	}
	
	public double generateAmountValue() {
		return this.getQuarter1_amount() + this.getQuarter2_amount() + this.getQuarter3_amount() + this.getQuarter4_amount();
	}
	//
	public void generateBalanceAmountValue() {
		this.setBalance_amount(this.getQuarter1_amount() + this.getQuarter2_amount() + this.getQuarter3_amount() + this.getQuarter4_amount());
	}
	
	// SUM ActivityFinancialSource Lists !
	public void sumActivityFinancialSourceBalances(Balance balance) {
		this.setQuarter1_amount(this.getQuarter1_amount() + balance.getQuarter1_amount());
		this.setQuarter2_amount(this.getQuarter2_amount() + balance.getQuarter2_amount());
		this.setQuarter3_amount(this.getQuarter3_amount() + balance.getQuarter3_amount());
		this.setQuarter4_amount(this.getQuarter4_amount() + balance.getQuarter4_amount());
		this.setBalance_amount(this.balance_amount + balance.balance_amount);
		Map<String, Double> map_q1 = sumFinancialSourceLists(this.getQuarter1(), balance.getQuarter1());
		List<SuperFinancialSource> q1 = new ArrayList<>();
		for (Map.Entry<String, Double> entry : map_q1.entrySet()) {
			ActivityFinancialSource activityFinancialSource = new ActivityFinancialSource(entry.getKey(), entry.getValue());
			q1.add(activityFinancialSource);
		}
		this.setQuarter1(q1);
		Map<String, Double> map_q2 = sumFinancialSourceLists(this.getQuarter2(), balance.getQuarter2());
		List<SuperFinancialSource> q2 = new ArrayList<>();
		for (Map.Entry<String, Double> entry : map_q2.entrySet()) {
			ActivityFinancialSource activityFinancialSource = new ActivityFinancialSource(entry.getKey(), entry.getValue());
			q1.add(activityFinancialSource);
		}
		this.setQuarter2(q2);
		Map<String, Double> map_q3 = sumFinancialSourceLists(this.getQuarter3(), balance.getQuarter3());
		List<SuperFinancialSource> q3 = new ArrayList<>();
		for (Map.Entry<String, Double> entry : map_q3.entrySet()) {
			ActivityFinancialSource activityFinancialSource = new ActivityFinancialSource(entry.getKey(), entry.getValue());
			q1.add(activityFinancialSource);
		}
		this.setQuarter3(q3);
		Map<String, Double> map_q4 = sumFinancialSourceLists(this.getQuarter4(), balance.getQuarter4());
		List<SuperFinancialSource> q4 = new ArrayList<>();
		for (Map.Entry<String, Double> entry : map_q4.entrySet()) {
			ActivityFinancialSource activityFinancialSource = new ActivityFinancialSource(entry.getKey(), entry.getValue());
			q1.add(activityFinancialSource);
		}
		this.setQuarter4(q4);
	}
	
	// SUM ProjectFinancialSource Lists !
	public void sumProjectFinancialSourceBalances(Balance balance) {
		Map<String, Double> map_q1 = sumFinancialSourceLists(this.getQuarter1(), balance.getQuarter1());
		List<SuperFinancialSource> q1 = new ArrayList<>();
		for (Map.Entry<String, Double> entry : map_q1.entrySet()) {
			ProjectFinancialSource projectFinancialSource = new ProjectFinancialSource(entry.getKey(), entry.getValue());
			q1.add(projectFinancialSource);
		}
		this.setQuarter1(q1);
		Map<String, Double> map_q2 = sumFinancialSourceLists(this.getQuarter2(), balance.getQuarter2());
		List<SuperFinancialSource> q2 = new ArrayList<>();
		for (Map.Entry<String, Double> entry : map_q2.entrySet()) {
			ProjectFinancialSource projectFinancialSource = new ProjectFinancialSource(entry.getKey(), entry.getValue());
			q2.add(projectFinancialSource);
		}
		this.setQuarter2(q2);
		Map<String, Double> map_q3 = sumFinancialSourceLists(this.getQuarter3(), balance.getQuarter3());
		List<SuperFinancialSource> q3 = new ArrayList<>();
		for (Map.Entry<String, Double> entry : map_q3.entrySet()) {
			ProjectFinancialSource projectFinancialSource = new ProjectFinancialSource(entry.getKey(), entry.getValue());
			q3.add(projectFinancialSource);
		}
		this.setQuarter3(q3);
		Map<String, Double> map_q4 = sumFinancialSourceLists(this.getQuarter4(), balance.getQuarter4());
		List<SuperFinancialSource> q4 = new ArrayList<>();
		for (Map.Entry<String, Double> entry : map_q4.entrySet()) {
			ProjectFinancialSource projectFinancialSource = new ProjectFinancialSource(entry.getKey(), entry.getValue());
			q4.add(projectFinancialSource);
		}
		this.setQuarter4(q4);
	}
	
	private Map<String, Double> sumFinancialSourceLists(List<SuperFinancialSource> listFinancialSources1, List<SuperFinancialSource> listFinancialSources2) {
		Map<String, Double> map = new HashMap<>();
		for (int i = 0; i < listFinancialSources1.size(); i++) {
			if (map.containsKey(listFinancialSources1.get(i).getName())) {
				map.put(listFinancialSources1.get(i).getName(), map.get(listFinancialSources1.get(i).getName()) + listFinancialSources1.get(i).getAmount());
			} else {
				map.put(listFinancialSources1.get(i).getName(), listFinancialSources1.get(i).getAmount());
			}
		}
		for (int i = 0; i < listFinancialSources2.size(); i++) {
			if (map.containsKey(listFinancialSources2.get(i).getName())) {
				map.put(listFinancialSources2.get(i).getName(), map.get(listFinancialSources2.get(i).getName()) + listFinancialSources2.get(i).getAmount());
			} else {
				map.put(listFinancialSources2.get(i).getName(), listFinancialSources2.get(i).getAmount());
			}
		}
		return map;
	}
	
}
