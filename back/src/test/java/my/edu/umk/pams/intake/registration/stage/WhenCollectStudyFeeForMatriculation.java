package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
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

@Autowired
private AdmissionService admissionService;

@ProvidedScenarioState
private InUser user;

@ExpectedScenarioState
private InIntake intake;

@ExpectedScenarioState
private InIntakeApplication intakeApplication;

@ProvidedScenarioState
private List<InCandidate> candidates;

//TODO all study fee pending

	 public WhenCollectStudyFeeForMatriculation I_want_to_collect_study_fee_for_matriculation_$(String referenceNo){
		 
		 intake = policyService.findIntakeByReferenceNo(intake.getReferenceNo());
		 
		 

	   
	     return self();
		 
		 
	 }


}
