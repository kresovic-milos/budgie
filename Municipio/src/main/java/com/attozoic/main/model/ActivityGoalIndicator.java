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

import com.attozoic.main.model.balance.BalanceText;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="activity_goal_indicators")
@Data
@EqualsAndHashCode(callSuper=true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "uid", scope=ActivityGoalIndicator.class)
public class ActivityGoalIndicator extends SuperEntity {

	private Long categoryID;	
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="activityGoalIndicator")
	List<BalanceText> balancesText = new ArrayList<>();

    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="activityGoal_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private ActivityGoal activityGoal;
	
	public ActivityGoalIndicator() {}

    public void addRebalance() {
    	try {
    		this.balancesText.add(2, new BalanceText());
    	} catch(IndexOutOfBoundsException ex) {}
    }
    
    public void removeRebalance() {
    	this.balancesText.remove(3);
    }
	
}
