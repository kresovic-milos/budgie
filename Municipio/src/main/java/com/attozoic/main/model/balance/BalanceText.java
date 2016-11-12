package com.attozoic.main.model.balance;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.attozoic.main.model.ActivityGoalIndicator;
import com.attozoic.main.model.ProgrammeGoalIndicator;
import com.attozoic.main.model.ProjectGoalIndicator;
import com.attozoic.main.model.RebalancesCount;
import com.attozoic.main.model.SuperEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
	
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="programmeGoalIndicator_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private ProgrammeGoalIndicator programmeGoalIndicator;
	
    @ManyToOne
	@JoinColumn(name="activityGoalIndicator_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private ActivityGoalIndicator activityGoalIndicator;
    
    @ManyToOne
	@JoinColumn(name="projectGoalIndicator_uid")
    @NotFound(action=NotFoundAction.IGNORE)
    private ProjectGoalIndicator projectGoalIndicator;
    
    public BalanceText() {}
    
}
