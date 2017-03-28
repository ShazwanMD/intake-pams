package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenTheApplicationIsWithdrawn extends Stage<ThenTheApplicationIsWithdrawn> {

	
	private static final Logger LOG = LoggerFactory.getLogger(ThenTheApplicationIsWithdrawn.class);

	@Autowired
    private ApplicationService applicationService;
	
	@ExpectedScenarioState
	InIntake intake;
	
	@ExpectedScenarioState
	InApplicant applicant;
	
	public ThenTheApplicationIsWithdrawn The_Application_Is_Withdrawn() {
	
		Assert.notNull(InBidStatus.WITHDRAWN, "withdraw application is null");
		return self();
	}
}
