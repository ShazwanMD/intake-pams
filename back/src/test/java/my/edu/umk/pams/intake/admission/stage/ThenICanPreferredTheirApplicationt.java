package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;

@JGivenStage
public class ThenICanPreferredTheirApplicationt extends Stage<ThenICanPreferredTheirApplicationt> {

	@ExpectedScenarioState
	private InCandidate candidate;
	
	public ThenICanPreferredTheirApplicationt I_can_preferred_their_application() {
		
		// do something
	return self();		
		
	}

}
