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
public class WhenIPullMatricNoInfo extends Stage<WhenIPullMatricNoInfo> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(WhenIPullMatricNoInfo.class);
	 
	@ExpectedScenarioState
    InIntakeSession intakeSession;

    @ExpectedScenarioState
    private InApplicant applicant;

	@ExpectedScenarioState
	private InIntake intake;
	
    @ProvidedScenarioState
    private List<InCandidate> candidates;

	public WhenIPullMatricNoInfo I_pull_matric_no_info() {
		

		for (InCandidate candidate : candidates) {
			
			LOG.debug("");
			LOG.debug("Candidates Name : {}", candidate.getName());
			LOG.debug("Candidates Matric number : {}", candidate.getMatricNo());	
			LOG.debug("");
		}
		
		
		

		
		return self();
	}

}