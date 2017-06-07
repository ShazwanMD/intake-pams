package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;

@JGivenStage
public class ThenCompleteApplicantRegistration extends Stage<ThenCompleteApplicantRegistration> {

	private static final Logger LOG = LoggerFactory.getLogger(ThenCompleteApplicantRegistration.class);
	
@ExpectedScenarioState
private InUser user;

@ExpectedScenarioState
private InIntake intake;	

@ExpectedScenarioState
InApplicant applicant;

@ProvidedScenarioState
private InIntakeApplication application;

@ExpectedScenarioState
private List<InCandidate> candidates;

	  public ThenCompleteApplicantRegistration I_can_complete_applicant_registration() {
		  
		  for (InCandidate candidate : candidates) {
				
				 Assert.notNull(InBidStatus.SELECT, "candidate is not selected");
			     LOG.debug("intake application status is {}", candidate.getStatus());
				
			}
		  
		  return self();
	  }
}
