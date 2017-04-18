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
public class WhenViewSelectedApplicantDetails extends Stage<WhenViewSelectedApplicantDetails> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(WhenViewSelectedApplicantDetails.class);
	 
	@ExpectedScenarioState
    InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;

	@ExpectedScenarioState
	private InIntake intake;
	
    @ProvidedScenarioState
    private List<InCandidate> candidates;

	public WhenViewSelectedApplicantDetails View_selected_applicant_details() {
		

		for (InCandidate candidate : candidates) {
			
			LOG.debug("");
			LOG.debug("Candidates Name : {}", candidate.getName());
			LOG.debug("Candidates Name : {}", candidate.getEmail());
			LOG.debug("Candidates Name : {}", candidate.getIdentityNo());
			LOG.debug("Candidates Name : {}", candidate.getStudyMode().getDescriptionEn());
			LOG.debug("Candidates Name : {}", candidate.getStudyMode().getDescriptionMs());
			LOG.debug("");
		}
		
		
		

		
		return self();
	}

}
