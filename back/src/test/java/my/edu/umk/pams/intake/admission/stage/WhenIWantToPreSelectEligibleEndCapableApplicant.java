package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class WhenIWantToPreSelectEligibleEndCapableApplicant extends Stage<WhenIWantToPreSelectEligibleEndCapableApplicant> {

	@ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;
    
	public WhenIWantToPreSelectEligibleEndCapableApplicant I_want_to_pre_select_eligible_and_capable_applicants() {
				
		// masukkan prosesnya di sini
    	return self();
    }
}
