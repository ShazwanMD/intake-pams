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
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@JGivenStage
public class WhenActivateStudentAdmission extends Stage<WhenActivateStudentAdmission> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenActivateStudentAdmission.class);

	@Autowired
	private PolicyService policyService;
	
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
	
	 public WhenActivateStudentAdmission I_want_to_activate_student_during_registration_$(String identityNo, String intakeSession){
		 		 
		 admissionService.RegisterCandidate(candidates);
		 for (InCandidate candidate : candidates) {
			LOG.debug("candidates status for : {} ", candidate.getStatus());
			LOG.debug("candidates status for : {} ", candidate.isRegistration());
			
				
				}
		 
		 
		 return self();
	 }
	 }

