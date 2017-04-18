package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;



@JGivenStage
public class WhenIPullSelectedApplicantsDetails extends Stage<WhenIPullSelectedApplicantsDetails> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(WhenIPullSelectedApplicantsDetails.class);
	 
	@ExpectedScenarioState
    InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;

	@ExpectedScenarioState
	private InIntake intake;
	
    @ProvidedScenarioState
    private List<InCandidate> candidates;

	public WhenIPullSelectedApplicantsDetails I_pull_selected_applicant_details() {
		

		for (InCandidate candidate : candidates) {
			
			LOG.debug("");
			LOG.debug("Candidates Name : {}", candidate.getName());
			LOG.debug("Credential number : {}", candidate.getIdentityNo());	
			//pending weather or not, payment source column is needed in Incandidate for registration payment
			LOG.debug("");
		}
		
		
		

		
		return self();
	}

}