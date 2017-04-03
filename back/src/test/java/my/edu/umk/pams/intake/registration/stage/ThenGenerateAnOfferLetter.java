package my.edu.umk.pams.intake.registration.stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.util.Assert;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
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
public class ThenGenerateAnOfferLetter extends Stage<ThenGenerateAnOfferLetter> {

	@ExpectedScenarioState
	InIntakeApplication applicants;

	@ExpectedScenarioState
	private InIntake intake;
	 
	@ProvidedScenarioState
	InCandidate candidate;

    @Autowired
    private AuthenticationManager authenticationManager;
    
	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private AdmissionService admissionService;
	

	public ThenGenerateAnOfferLetter generate_an_offer_letter() {
		
		candidate = admissionService.findCandidateByIdentityNo(applicants.getApplicant().getIdentityNo());
		admissionService.offerCandidate(candidate);
		Assert.notNull(candidate, "candidate is required");
		return self();
		
	}
} 

