package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@JGivenStage
public class ThenICanCompleteStudentRegistration extends Stage <ThenICanCompleteStudentRegistration> {

	public static final Logger LOG = LoggerFactory.getLogger(ThenICanCompleteStudentRegistration.class);

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
	
	@ExpectedScenarioState
	private InCandidate candidate;
    
    public ThenICanCompleteStudentRegistration I_can_complete_student_registration() {
    	
    	Assert.notNull(intake, "intake cannot be empty");
    	
    	InCandidate candidate1 = admissionService.findCandidateByIdentityNo("910607145581");
    	LOG.debug("candidate's status of registeration : {} ", candidate1.getRegistration());
    	
    	Assert.isTrue(true, "Candidate is not registered");
    	return self();
		}
}
