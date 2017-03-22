package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;

@JGivenStage
public class ThenICanFilterTheTopApplicant extends Stage<ThenICanFilterTheTopApplicant> {

    @ExpectedScenarioState
    private InCandidate candidate;

    public ThenICanFilterTheTopApplicant I_can_filter_the_top_applicant() {

        // do something
        return self();
    }

}