package com.attozoic.main.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.balance.BalanceText;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="programme_goal_indicators")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ProgrammeGoalIndicator.class)
@JsonTypeName("programmeGoalIndicator")
public class ProgrammeGoalIndicator extends SuperGoalIndicator {

	private Long categoryID;
	
	private String type;
	
	private String name;
	
	//@Column(name = "verification_source", nullable = false, columnDefinition = "varchar(511) default ''")
	private String verificationSource;
	
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="programmeGoal_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    @JsonIgnoreProperties({"categoryID", "code", "name", "programme", "programmeGoalIndicators"})
    private ProgrammeGoal programmeGoal;
	
	public ProgrammeGoalIndicator() {
		this.type = "programmeGoalIndicator";
	}	
	
	public void generateBalancesText(int numRebalances) {
		this.balancesText.add(new BalanceText("", 2016, this));
		this.balancesText.add(new BalanceText("", 2017, this));
		if (numRebalances > 0) {
			for (int i = 0; i < numRebalances; i++) {
				this.balancesText.add(new BalanceText("",  2017 + (i + 1) * 0.1, this));
			}
		}
		this.balancesText.add(new BalanceText("", 2018, this));
		this.balancesText.add(new BalanceText("", 2019, this));
		//this.balancesText.add(new BalanceText("", 100, this));
	}
	
    public void addRebalance(int numRebalances) {
    	this.balancesText.add(this.balancesText.size()-2, new BalanceText("", 2017 + (numRebalances + 1) * 0.1, this));
    }
    
    public void removeRebalance(int numRebalances) {
    	this.balancesText.remove(numRebalances-3);
    }
	
}
