package com.attozoic.main.model;

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

import com.attozoic.main.model.balance.BalanceContainer;
import com.attozoic.main.model.balance.BalanceEconomicAccount;
import com.attozoic.main.model.balance.BalanceNumeric;
import com.attozoic.main.model.balance.BalanceWithQuarters;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="project_economic_accounts")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ProjectEconomicAccount.class)
public class ProjectEconomicAccount extends SuperEntity {
	
	// SAM SEBI DODAJE REBALANS!!!!!!!!!!!
	
	private String code;
	private String categoryName;
	private String name;
	private String poz;
	private String financialSrc;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="projectEconomicAccount")
	List<BalanceContainer> balanceContainers = new ArrayList<>(4);

	private double sumExpenses123Budget = sumExpenses123Budget();
	private double sumExpenses123Others = sumExpenses123Others();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private Project project;
    
    public ProjectEconomicAccount() {
    	for (int i = 0; i < 4; i++) {
    		if (i==1) {
    			balanceContainers.add(new BalanceContainer(2));
    			continue;
    		} 
    		balanceContainers.add(new BalanceContainer(1));
    	}
    }
    
    public void addRebalance() {
    	try {
    		this.balanceContainers.add(2, new BalanceContainer(2));
    	} catch(IndexOutOfBoundsException ex) {}
    }
    
    public void removeRebalance() {
    	this.balanceContainers.remove(3);
    }
    
    public double sumExpenses123Budget() {
    	double sum = 0;
    	for (int i = 0; i < this.balanceContainers.size(); i+=2) {
    		BalanceContainer balanceContainer = this.balanceContainers.get(i);
    		for (int j = 0; j < balanceContainer.getBalances().size(); j++) {
    			BalanceEconomicAccount bec = balanceContainer.getBalances().get(j);
    			if (bec instanceof BalanceWithQuarters) {
    				sum += ((BalanceWithQuarters) bec).getSumQuarters();
    			} else if (bec instanceof BalanceNumeric) {
    				sum += ((BalanceNumeric) bec).getValue();
    			}
    		}
    	}
    	return sum;
    }
    
    public double sumExpenses123Others() {
    	double sum = 0;
    	for (int i = 1; i < this.balanceContainers.size(); i+=2) {
    		BalanceContainer balanceContainer = this.balanceContainers.get(i);
    		for (int j = 0; j < balanceContainer.getBalances().size(); j++) {
    			BalanceEconomicAccount bec = balanceContainer.getBalances().get(j);
    			if (bec instanceof BalanceWithQuarters) {
    				sum += ((BalanceWithQuarters) bec).getSumQuarters();
    			} else if (bec instanceof BalanceNumeric) {
    				sum += ((BalanceNumeric) bec).getValue();
    			}
    		}
    	}
    	return sum;
    }
    
}
