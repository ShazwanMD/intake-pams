package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;

@JGivenStage
public class ThenICanInformTheSelectedApplicants extends Stage<ThenICanInformTheSelectedApplicants> {

    @ExpectedScenarioState
    private InCandidate candidate;

    public ThenICanInformTheSelectedApplicants I_can_inform_the_selected_applicants() {

        //Kena buat method kat sini
        return self();

    }

}
