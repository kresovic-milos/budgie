package com.attozoic.main.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.attozoic.main.model.balance.Balance;
import com.attozoic.main.model.balance.BalanceType;

import lombok.Data;

@Data
public class DtoProgrammeEconomicAccount implements Comparable<DtoProgrammeEconomicAccount> {

	private String name;
	
	private List<Balance> balances = new ArrayList<>();
	
	private double sumExpenses123Budget = 0;
	private double sumExpenses123Others = 0;
	
	public DtoProgrammeEconomicAccount() {}
	
	public DtoProgrammeEconomicAccount(String name, List<Balance> balances) {
		this.name = name;
		this.balances = balances;
	}
	
	public void generateBalances(int numRebalances) {
		this.balances.add(new Balance(BalanceType.BUDGET, 2016, null));
		this.balances.add(new Balance(BalanceType.OTHERS, 2016, null));
		this.balances.add(new Balance(BalanceType.BUDGET, 2017, null));
		this.balances.add(new Balance(BalanceType.OTHERS, 2017, null));
		if (numRebalances > 0) {
			for (int i = 0; i < numRebalances; i++) {
				this.balances.add(new Balance(BalanceType.BUDGET, 2017 + (i + 1) * 0.1, null));
				this.balances.add(new Balance(BalanceType.OTHERS, 2017 + (i + 1) * 0.1, null));
			}
		}
		this.balances.add(new Balance(BalanceType.BUDGET, 2018, null));
		this.balances.add(new Balance(BalanceType.OTHERS, 2018, null));
		this.balances.add(new Balance(BalanceType.BUDGET, 2019, null));
		this.balances.add(new Balance(BalanceType.OTHERS, 2019, null));
	}
	
    public void generateSumExpences123() {
    	this.setSumExpenses123Budget(0);
    	this.setSumExpenses123Others(0);
		for (int i = 2; i < this.balances.size(); i++) {
    		if (this.balances.get(i).getBalanceType() == BalanceType.BUDGET) {
    			this.setSumExpenses123Budget(this.getSumExpenses123Budget() + this.balances.get(i).getBalance_amount());
    		} else {
    			this.setSumExpenses123Others(this.getSumExpenses123Others() + this.balances.get(i).getBalance_amount());
    		}
    	}
    }
    
    public DtoProgrammeEconomicAccount sumProgrammeEconomicAccounts(DtoProgrammeEconomicAccount programmeEconomicAccount) {
    	DtoProgrammeEconomicAccount programmeEconomicAccount2 = new DtoProgrammeEconomicAccount();
    	List<Balance> list = new ArrayList<>();
    	for (int i = 0; i < this.balances.size(); i++) {
    		list.add(this.balances.get(i).sumBalancesSameYearAndType(programmeEconomicAccount.getBalances().get(i)));
    	}
    	programmeEconomicAccount2.setBalances(list);
    	programmeEconomicAccount2.generateSumExpences123();
    	return programmeEconomicAccount2;
    }

	@Override
	public int compareTo(DtoProgrammeEconomicAccount o) {
		return this.getName().substring(0, 9).compareTo(o.getName().substring(0, 9));
	}
	
}
