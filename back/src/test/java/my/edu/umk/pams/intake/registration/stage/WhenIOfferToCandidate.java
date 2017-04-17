package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.common.service.CommonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenIOfferToCandidate extends Stage<WhenIOfferToCandidate> {
    private static final Logger LOG = LoggerFactory.getLogger(WhenIOfferToCandidate.class);
    
    @Autowired
    private AdmissionService admissionService;
       
    @ProvidedScenarioState
    private List<InCandidate> candidates;

    public WhenIOfferToCandidate I_offer_to_candidate_in_intake_session_$(String referenceNo) {
    	
     //   InCandidate candidate1 = admissionService.findCandidateByIdentityNo("870607149913");
     //   LOG.debug("prefix for : {} ", candidate1.getProgramSelection());
    	
        for (InCandidate candidate : candidates) {

        	admissionService.offerCandidate(candidate);
            String expected = referenceNo;
            String found = candidate.getIntake().getReferenceNo();
            Assert.isTrue(referenceNo.equals(found), "Expected " + expected + ", found " + found);
            LOG.debug("candidates status for : {} ", candidate.getName());
            LOG.debug("candidates status for : {} ", candidate.getStatus());
        }
        


        return self();
    }
}
