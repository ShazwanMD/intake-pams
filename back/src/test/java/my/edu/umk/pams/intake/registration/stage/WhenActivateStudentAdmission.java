package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenActivateStudentAdmission extends Stage<WhenActivateStudentAdmission> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenActivateStudentAdmission.class);

	@Autowired
	private AdmissionService admissionService;

    @ExpectedScenarioState
    List<InIntakeApplication>  applications;
    
    @Autowired
    ApplicationService applicationService;

	@ExpectedScenarioState
	private InIntakeApplication intakeApplication;
	
	@ExpectedScenarioState
    private InIntake intake; 
    
	@ExpectedScenarioState
    private List<InCandidate> candidates;
	
	public WhenActivateStudentAdmission I_want_to_activate_student_during_registration_$(String identityNo,
			String intakeSession) {
		admissionService.registerCandidates(intake, candidates);
		for (InCandidate candidate : candidates) {
			LOG.debug("candidate {}'s registration status : {} ", candidate.getName(), candidate.isRegistration());

		}

		return self();
	}
}
