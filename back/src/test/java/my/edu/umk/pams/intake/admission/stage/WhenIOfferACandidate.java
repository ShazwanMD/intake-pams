package my.edu.umk.pams.intake.admission.stage;

import io.jsonwebtoken.lang.Assert;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import my.edu.umk.pams.bdd.stage.GivenIAmCPSAdministrator;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class WhenIOfferACandidate extends Stage<WhenIOfferACandidate>{
	
	private static final Logger LOG = LoggerFactory.getLogger(GivenIAmCPSAdministrator.class);
	
	@Autowired
	private PolicyService policyService;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @ProvidedScenarioState
    InIntakeApplication applicants;
    
    @Autowired
    ApplicationService applicationService;
    

	public WhenIOfferACandidate I_offer_a_candidate_in_current_intake_session_$(String intakeSession) {
		InIntake intake = policyService.findIntakeByReferenceNo(intakeSession);
		LOG.debug("intake {}", intake);
		List<InIntakeApplication> applicants = applicationService.findIntakeApplications(intake,InBidStatus.PROCESSING);
		LOG.debug("applicants {}", applicants);
		for (InIntakeApplication inIntakeApplication : applicants) {
			Assert.notNull(inIntakeApplication, "list is null");
			//inIntakeApplication.setBidStatus(InBidStatus.SELECTED);
		}
		
		return self();
	}

}
