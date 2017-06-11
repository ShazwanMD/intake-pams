package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;


@JGivenStage
public class ThenProceedRegistrationForSelectedApplicants extends Stage<ThenProceedRegistrationForSelectedApplicants> {
	
 	private static final Logger LOG = LoggerFactory.getLogger(ThenProceedRegistrationForSelectedApplicants.class);
 	
	@Autowired
	ApplicationService applicationService;

	@Autowired
	PolicyService policyService;
	
	@Autowired
	AdmissionService admissionService;
	
	@ExpectedScenarioState
	InIntake intake;
	
	@ExpectedScenarioState
	InApplicant applicant;
	
    @ExpectedScenarioState
    private List<InCandidate> candidates;

	 
	 public ThenProceedRegistrationForSelectedApplicants Proceed_Registration_For_Selected_Applicants() {
		 

			for (InCandidate candidate : candidates) {
				
				Assert.notNull(InBidStatus.SELECTED, "candidate is not selected");
			 
				
			}
			
		

		 
		
		 return self();
	 }

}