package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;


@JGivenStage
public class WhenCandidateAcceptOffer extends Stage<WhenCandidateAcceptOffer>{
 
	private static final Logger LOG = LoggerFactory.getLogger(WhenCandidateAcceptOffer.class);
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private AdmissionService admissionService;
	
	@Autowired
	ApplicationService applicationService;
	
	@ExpectedScenarioState
    private InIntake intake; 

	@ProvidedScenarioState
	private InCandidate candidate;
	
	@ExpectedScenarioState
	private List<InCandidate> candidates;
	

	
	public WhenCandidateAcceptOffer i_accept_offer_$(String identityNo, String intakeSession) {
	
		for (InCandidate candidate : candidates) {
			
	    candidate.setStatus(InCandidateStatus.APPROVED);
		admissionService.updateSelectedCandidate(candidate);	
		LOG.debug("candidates status for : {} ", candidate.getName());
		LOG.debug("candidates status for : {} ", candidate.getStatus());
		
		}
		return self();
	}
}
