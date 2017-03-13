package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenCandidateCanProceedToNextSelectionPhase extends Stage<ThenCandidateCanProceedToNextSelectionPhase> {

    @ExpectedScenarioState
    private InCandidate candidate;

    @Autowired
    private AdmissionService admissionService;

    public ThenCandidateCanProceedToNextSelectionPhase candidate_can_proceed() {

        Assert.notNull(candidate , "candidate is required");
        InCandidate found = admissionService.findCandidateByIdentityNo(candidate.getIdentityNo());
        Assert.isTrue(InCandidateStatus.PREAPPROVED.equals(found.getStatus()),
                "Candidate should be preapproved");

        // do something
        return self();
    }

}
