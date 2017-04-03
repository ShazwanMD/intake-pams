package my.edu.umk.pams.intake.application.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;

@JGivenStage
public class WhenCandidateWithdrawApplication extends Stage<WhenCandidateWithdrawApplication>{
	private static final Logger LOG = LoggerFactory.getLogger(WhenCandidateWithdrawApplication.class);
	@Autowired
	private AdmissionService admissionService;

	@ExpectedScenarioState
    private InIntake intake;

	@ExpectedScenarioState
    private InIntakeSession intakeSession;
	
	@ExpectedScenarioState
    private InIntakeApplication intakeApplication;
	
    @ExpectedScenarioState
    private InCandidate candidate;
    
    public WhenCandidateWithdrawApplication candidate_withdraw_Application(){
    	
  //  todo	admissionService. candidate declined status xde lg setup dlm service
    	return self();
    }
}
