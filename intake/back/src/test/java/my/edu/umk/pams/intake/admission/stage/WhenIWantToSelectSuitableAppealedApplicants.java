package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class WhenIWantToSelectSuitableAppealedApplicants extends Stage<WhenIWantToSelectSuitableAppealedApplicants> {

    @ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;

    public WhenIWantToSelectSuitableAppealedApplicants I_want_to_select_suitable_appealed_applicants() {

        // TODO Auto-generated method stub
        return self();
    }

}
