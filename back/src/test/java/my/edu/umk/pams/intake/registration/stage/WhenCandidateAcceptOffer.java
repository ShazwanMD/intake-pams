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
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;


@JGivenStage
public class WhenCandidateAcceptOffer extends Stage<WhenCandidateAcceptOffer>{
 
	private static final Logger LOG = LoggerFactory.getLogger(WhenCandidateAcceptOffer.class);
	
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
	
		LOG.debug("intake status : {} ", intake);
		
		for (InCandidate candidate : candidates) {
			
	    candidate.setStatus(InCandidateStatus.ACCEPTED);
		admissionService.updateSelectedCandidate(candidate);	
		LOG.debug("candidate {} has {} the offer", candidate.getName(),candidate.getStatus());
		
		}
		return self();
	}
	
	public WhenCandidateAcceptOffer a_candidate_accept_offer_$(String identityNo, String intakeSession) {
		
		LOG.debug("intake status : {} ", intake);
		
		InCandidate candidate1 = admissionService.findCandidateByIdentityNo("910607145581");
		LOG.debug("candidate1 status : {} ", candidate1);
	    candidate1.setStatus(InCandidateStatus.ACCEPTED);
		admissionService.updateSelectedCandidate(candidate1);	
		LOG.debug("candidate status: {}", candidate1.getStatus());

		return self();
	}
}
