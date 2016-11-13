package com.attozoic.main.model.balance;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.model.SuperEntity;
import com.attozoic.main.model.SuperGoalIndicator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "balance_text")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=RebalancesCount.class)
public class BalanceText extends SuperEntity {

	private String value;
	private double year;
	
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="superGoalIndicator_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    @JsonIgnoreProperties({"categoryID", "name", "programmeGoal", "activityGoal", "projectGoal"})
    private SuperGoalIndicator superGoalIndicator;
    
    public BalanceText() {}
    
    public BalanceText(String value, double year, SuperGoalIndicator superGoalIndicator) {
    	this.value = value;
    	this.year = year;
    	this.superGoalIndicator = superGoalIndicator;
    }
    
}
