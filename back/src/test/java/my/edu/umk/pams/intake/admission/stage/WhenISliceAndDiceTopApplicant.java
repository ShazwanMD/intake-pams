package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class WhenISliceAndDiceTopApplicant extends Stage<WhenISliceAndDiceTopApplicant> {

    @ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;

    public WhenISliceAndDiceTopApplicant I_slide_and_dice_top_applicant_for_intake() {

        // masukkan prosesnya di sini
        return self();
    }
}
