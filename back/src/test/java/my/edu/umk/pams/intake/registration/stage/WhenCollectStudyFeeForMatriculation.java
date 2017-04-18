package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@JGivenStage
public class WhenCollectStudyFeeForMatriculation extends Stage<WhenCollectStudyFeeForMatriculation> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(WhenCollectStudyFeeForMatriculation.class);
	 
@Autowired
private PolicyService policyService;

@Autowired
private ApplicationService applicationService;

@ProvidedScenarioState
private InUser user;

@ExpectedScenarioState
private InIntake intake;

//TODO all study fee pending

	 public WhenCollectStudyFeeForMatriculation I_want_to_collect_study_fee_for_matriculation() {
		 
		 intake = policyService.findIntakeByReferenceNo(intake.getReferenceNo());
		 
		 LOG.debug("intake is : {}", intake);
	     applicationService.findIntakeApplications(intake, InBidStatus.SUBMITTED); 

	   
	     return self();
		 
		 
	 }


}
