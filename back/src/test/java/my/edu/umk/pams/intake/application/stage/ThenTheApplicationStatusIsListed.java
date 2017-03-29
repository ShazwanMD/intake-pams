package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;


import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenTheApplicationStatusIsListed extends Stage<ThenTheApplicationStatusIsListed> {

	
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheApplicationStatusIsListed.class);

	@ExpectedScenarioState
	InIntake intake;
	
	@ExpectedScenarioState
	InApplicant applicant;
	
    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
	
	public ThenTheApplicationStatusIsListed Application_Status_Listed() {
	
		Assert.notNull(intakeApplication.getBidStatus(), "withdraw application is null");
		return self();
	}
}
