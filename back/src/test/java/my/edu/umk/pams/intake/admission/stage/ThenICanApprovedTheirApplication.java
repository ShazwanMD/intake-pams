package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;

@JGivenStage
public class ThenICanApprovedTheirApplication extends Stage<ThenICanApprovedTheirApplication> {

    @ExpectedScenarioState
    private InCandidate candidate;

    public ThenICanApprovedTheirApplication I_can_approved_their_application() {

        // TODO make ur job here
    	// Dont know how to caary from before
        return self();

    }

}
