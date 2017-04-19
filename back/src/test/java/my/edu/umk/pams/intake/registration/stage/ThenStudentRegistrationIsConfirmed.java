package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import io.jsonwebtoken.lang.Assert;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class ThenStudentRegistrationIsConfirmed extends Stage<ThenStudentRegistrationIsConfirmed> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenStudentRegistrationIsConfirmed.class);

	@Autowired
	private AdmissionService admissionService;
    
    @Autowired
    ApplicationService applicationService;

	@ExpectedScenarioState
	private InIntakeApplication intakeApplication;
	
	@ExpectedScenarioState
    private InIntake intake; 
    
	@ExpectedScenarioState
    private List<InCandidate> candidates;

	
	public ThenStudentRegistrationIsConfirmed student_registration_is_confirmed() {
		
		for (InCandidate candidate : candidates) {
            
			Assert.notNull(candidate.getRegistration());
			LOG.debug("candidates {} are confirmed to be registered : {} ", candidate.getName(), candidate.getRegistration());
			
		}
		
		return self();
	}
		 

}
