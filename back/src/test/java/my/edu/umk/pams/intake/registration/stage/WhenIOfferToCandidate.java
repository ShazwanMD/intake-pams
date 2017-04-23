package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenIOfferToCandidate extends Stage<WhenIOfferToCandidate> {
    private static final Logger LOG = LoggerFactory.getLogger(WhenIOfferToCandidate.class);
    
    @Autowired
    private AdmissionService admissionService;
    
    @Autowired
    private PolicyService policyService;
    
    @ExpectedScenarioState
    private InIntake intake;
       
    @ProvidedScenarioState
    private List<InCandidate> candidates;

    public WhenIOfferToCandidate I_offer_to_candidate_in_intake_session_$(String referenceNo) {

      candidates = admissionService.findCandidatesByStatus(intake, InCandidateStatus.SELECTED);
   
		for (InCandidate candidate : candidates) {

			admissionService.offerCandidate(candidate);

			Assert.notNull(candidate.getMatricNo(), "candidate's matric number is not generated");

			LOG.debug("candidates {} has a matric nombor of : {} ", candidate.getName(), candidate.getMatricNo());

			String expected = referenceNo;
			String found = candidate.getIntake().getReferenceNo();
			Assert.isTrue(referenceNo.equals(found), "Expected " + expected + ", found " + found);

		}
        


        return self();
    }
}