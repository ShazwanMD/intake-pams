package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class WhenIWantToReviewApplicationsFlaggedAsAppeal extends Stage <WhenIWantToReviewApplicationsFlaggedAsAppeal> {

	@ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;

	public WhenIWantToReviewApplicationsFlaggedAsAppeal I_want_to_review_applications_flagged_as_appeal() {
		
		// TODO Auto-generated method stub
		return null;
			
	}

}
