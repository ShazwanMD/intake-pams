package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@JGivenStage
public class WhenIOfferToCandidate extends Stage<WhenIOfferToCandidate> {
    private static final Logger LOG = LoggerFactory.getLogger(WhenIOfferToCandidate.class);
    @ProvidedScenarioState
    private List<InCandidate> candidates;

    public WhenIOfferToCandidate I_offer_to_candidate_in_intake_session_$(String referenceNo) {
        for (InCandidate candidate : candidates) {

            //todo(ashraf) Nothing to implement to make 'offer' here??
            //todo(ashraf) Because we already set the following in the previous When
//            candidate.setStatus(InCandidateStatus.SELECTED);

            String expected = referenceNo;
            String found = candidate.getIntake().getReferenceNo();
            Assert.isTrue(referenceNo.equals(found), "Expected " + expected + ", found " + found);
            LOG.debug("candidates status for : {} ", candidate.getName());
            LOG.debug("candidates status for : {} ", candidate.getStatus());
        }

        return self();
    }
}
