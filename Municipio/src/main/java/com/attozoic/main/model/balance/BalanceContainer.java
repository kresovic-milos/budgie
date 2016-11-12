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

import com.attozoic.main.model.ActivityEconomicAccount;
import com.attozoic.main.model.ProjectEconomicAccount;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.model.SuperEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "balance_container")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=RebalancesCount.class)
public class BalanceContainer extends SuperEntity {

//	@ElementCollection
//	@CollectionTable(name = "balanceEconomicAccount", joinColumns = @JoinColumn(name = "balanceEconomicAccount_id"))
//	@OrderColumn
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="balanceContainer")
	private List<BalanceEconomicAccount> balances = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activityEconomicAccount_uid")
	@NotFound(action=NotFoundAction.IGNORE)
	private ActivityEconomicAccount activityEconomicAccount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="projectEconomicAccount_uid")
	@NotFound(action=NotFoundAction.IGNORE)
	private ProjectEconomicAccount projectEconomicAccount;
	
	public BalanceContainer() {
	}
	
	// Type 1 - Numeric
	// Type 2 - Quarters
	public BalanceContainer(int type) {
		if (type==1) {
			for (int i = 0; i < 2; i++) {
				BalanceNumeric balanceNumeric = new BalanceNumeric();
				balanceNumeric.setBalanceContainer(this);
				this.balances.add(balanceNumeric);
			}
		} else if (type==2) {
			for (int i = 0; i < 2; i++) {
				BalanceWithQuarters balanceWithQuarters = new BalanceWithQuarters();
				balanceWithQuarters.setBalanceContainer(this);
				this.balances.add(balanceWithQuarters);
			}
		}
	}
	
	public void sumBalanceContainers(BalanceContainer balanceContainer) {
		for (int i = 0; i < 2; i++) {
			this.balances.get(i).sumBalances(balanceContainer.getBalances().get(i));
		}
	}
	
}
