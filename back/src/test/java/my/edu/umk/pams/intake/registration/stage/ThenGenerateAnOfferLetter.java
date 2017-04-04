package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.util.Assert;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.admission.stage.ThenICanSubmitTheApplication;
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

	private static final Logger LOG = LoggerFactory.getLogger(ThenGenerateAnOfferLetter.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	 
	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private AdmissionService admissionService;
	
	@ExpectedScenarioState
	InIntakeApplication applicants;

	@ExpectedScenarioState
	private InIntake intake;
	 
	@ExpectedScenarioState
	InCandidate candidate;
	
	public ThenGenerateAnOfferLetter generate_an_offer_letter() {
		
		//candidate = admissionService.findCandidateByIdentityNo(applicants.getApplicant().getIdentityNo());
		//admissionService.offerCandidate(candidate);
		//Assert.notNull(candidate, "candidate is required");
		//return self();
		//Assert.notNull(applicants, "list is null");
		//InCandidate found = admissionService.findCandidateByIdentityNo(candidate.getIdentityNo());
       // Assert.isTrue(InCandidateStatus.SELECTED.equals(found.getStatus()), "generate offer letter");
        //Assert.notNull(candidate, "candidate is required");
       
        admissionService.findCandidateByIdentityNo(candidate.getIdentityNo());
        Assert.notNull(InCandidateStatus.SELECTED, "Selected list is null");
        //applicationService.submitIntakeApplication(intake, intakeApplication);
        //Assert.notNull(InBidStatus.SUBMITTED,"withdraw application is null");
        LOG.debug("candidate status {} :", candidate.getStatus());
        return self();
		
	}
} 

