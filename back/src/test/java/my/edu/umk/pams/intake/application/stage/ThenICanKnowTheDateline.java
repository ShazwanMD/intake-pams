package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenICanKnowTheDateline extends Stage<ThenICanKnowTheDateline> {
	
	@Autowired
    private PolicyService policyService;
   
	@ExpectedScenarioState
    private ApplicationService applicationService;
	 
    @ExpectedScenarioState
    private Date endDate;
    
    @ExpectedScenarioState
    private InIntake intake;
    
private static final Logger LOG = LoggerFactory.getLogger(ThenICanKnowTheDateline.class);
	
	public ThenICanKnowTheDateline I_can_know_the_dateline() {
		 
	 Assert.notNull(intake.getEndDate(), "end date is null");
	 		
	 
	 
	 return self();
	
	}

}
