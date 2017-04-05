package my.edu.umk.pams.intake.admission.stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.leader.Candidate;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateImpl;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

@JGivenStage
public class ThenICanGenerateAnOfferLetter extends
		Stage<ThenICanGenerateAnOfferLetter> {

	 private static final Logger LOG = LoggerFactory.getLogger(WhenIFillInIntakeApplication.class);
	
	@ExpectedScenarioState
	InIntakeApplication applicants;

	@ProvidedScenarioState
	InCandidate candidate;

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private AdmissionService admissionService;
	

	public ThenICanGenerateAnOfferLetter I_can_generate_an_offer_letter_in_current_intake_session_$(String intakeSession) {
		
		InIntake intake = policyService.findIntakeByReferenceNo(intakeSession);
		LOG.debug("intake {}", intake);
		List<InIntakeApplication> applicants = applicationService.findIntakeApplications(intake,InBidStatus.PROCESSING);
		LOG.debug("applicants_then {}", applicants);
		for (InIntakeApplication inIntakeApplication : applicants) {
			LOG.debug("inIntakeApplication {}", inIntakeApplication);
			LOG.debug("identity {}", inIntakeApplication.getApplicant().getIdentityNo());
			candidate = admissionService.findCandidateByIdentityNo(inIntakeApplication.getApplicant().getIdentityNo());
			LOG.debug("candidate_then {}", candidate);
			admissionService.offerCandidate(candidate);
		}
		
		return self();
		
	}
}
