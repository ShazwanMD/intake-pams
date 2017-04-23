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
	
	@ExpectedScenarioState
	private InCandidate candidate;
	
	public WhenActivateStudentAdmission I_want_to_activate_student_during_registration_$(String identityNo,
			String intakeSession) {
		
		admissionService.registerCandidates(intake, candidates);
		for (InCandidate candidate : candidates) {
			LOG.debug("candidate {}'s registration status : {} ", candidate.getName(), candidate.getRegistration());

		}

		return self();
	}
	
	public WhenActivateStudentAdmission I_scan_offer_letter_barcode_$(String identityNo,
			String intakeSession) {
		
		admissionService.registerCandidates(intake, candidates);
		
		for (InCandidate candidate : candidates) {
			LOG.debug("candidate {}'s matric no : {}  ", candidate.getName(), candidate.getMatricNo());
			LOG.debug("registration status : {}", candidate.getRegistration());
		}

		return self();
	}
	
	
	public WhenActivateStudentAdmission I_scan_offer_letter_barcode_for_a_candidate_$(String identityNo,
			String intakeSession) {
		
		InCandidate candidate1 = admissionService.findCandidateByIdentityNo("910607145581");

		admissionService.registerCandidates(intake, candidates);
		LOG.debug("candidate matric no : {}", candidate1.getMatricNo() );
		LOG.debug("candidate registration status : {}", candidate1.getRegistration() );
	
		return self();
	}
}
