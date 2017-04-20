package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.registration.service.RegistrationService;

@JGivenStage
public class WhenIWantToScanTheApplicantOfferLetterBarcode extends Stage <WhenIWantToScanTheApplicantOfferLetterBarcode> {

	public static final Logger LOG = LoggerFactory.getLogger(WhenIWantToScanTheApplicantOfferLetterBarcode.class);
	
	@Autowired
	private PolicyService policyService;
	
	@Autowired
	private AdmissionService admissionService;
    
    @Autowired
    ApplicationService applicationService;

	@ExpectedScenarioState
	private InIntakeApplication intakeApplication;
	
	@ExpectedScenarioState
    private InIntake intake;
	
	@ExpectedScenarioState
	private InCandidate candidate;
	

	public WhenIWantToScanTheApplicantOfferLetterBarcode I_want_to_scan_the_applicant_offer_letter_barcode_$(String identityNo,String intakeReferenceNo)  {
		
		policyService.findIntakeByReferenceNo(intakeReferenceNo);
		intake.getReferenceNo();
		LOG.debug("intake status {}", intake.getReferenceNo());
		
		admissionService.findCandidateByIdentityNo(identityNo);
		
		LOG.debug("candidate {}'s registration status : {} ", candidate.getName(), candidate.getRegistration());

		
		return self();
	}
	    
}
