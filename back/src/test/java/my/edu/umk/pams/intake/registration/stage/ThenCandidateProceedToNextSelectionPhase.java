package my.edu.umk.pams.intake.registration.stage;
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
public class ThenCandidateProceedToNextSelectionPhase extends Stage<ThenCandidateProceedToNextSelectionPhase> {

    @ExpectedScenarioState
    private InCandidate candidate;

    @Autowired
    private AdmissionService admissionService;

    public ThenCandidateProceedToNextSelectionPhase candidate_can_proceed_next_selection() {

        Assert.notNull(candidate, "candidate is required");
        InCandidate found = admissionService.findCandidateByIdentityNo(candidate.getIdentityNo());
        Assert.isTrue(InCandidateStatus.SELECTED.equals(found.getStatus()),"Candidate should be selected");
        		//PREAPPROVED.equals(found.getStatus()),
               // "Candidate should be preapproved");

        // do something
        return self();
    }

}



