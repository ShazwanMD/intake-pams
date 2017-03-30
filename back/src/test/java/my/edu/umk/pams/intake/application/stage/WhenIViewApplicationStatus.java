package my.edu.umk.pams.intake.application.stage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

/**
 * @author PAMS
 */
@JGivenStage
public class WhenIViewApplicationStatus extends Stage<WhenIViewApplicationStatus> {

	
	private static final Logger LOG = LoggerFactory.getLogger(WhenIViewApplicationStatus.class);

	@Autowired
    private ApplicationService applicationService;
	
	@Autowired
    private PolicyService policyService;
	
	@ExpectedScenarioState
	InIntake intake;
	
	@ExpectedScenarioState
	InApplicant applicant;
	
    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
	
	public WhenIViewApplicationStatus I_View_Application_Status() {
	


		 intakeApplication = applicationService.findIntakeApplicationByReferenceNo("20171/MASTER/001");
		 LOG.debug("intake status {}", intakeApplication.getBidStatus());
		 
		 
		 return self();
	}
}