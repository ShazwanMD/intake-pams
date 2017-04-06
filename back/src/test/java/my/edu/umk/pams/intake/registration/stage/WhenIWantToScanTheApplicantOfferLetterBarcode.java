package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.service.PolicyService;
import my.edu.umk.pams.intake.registration.service.RegistrationService;

@JGivenStage
public class WhenIWantToScanTheApplicantOfferLetterBarcode extends Stage <WhenIWantToScanTheApplicantOfferLetterBarcode> {

	public static final Logger LOG = LoggerFactory.getLogger(WhenIWantToScanTheApplicantOfferLetterBarcode.class);
	
	@Autowired
	private PolicyService policyService;
 
	@ProvidedScenarioState
	private InIntake intake;

	private String intakeReferenceNo = "201720181/MASTER";

	public WhenIWantToScanTheApplicantOfferLetterBarcode I_want_to_scan_the_applicant_offer_letter_barcode() {
		
		policyService.findIntakeByReferenceNo(intakeReferenceNo);
		intake.getReferenceNo();
		LOG.debug("intake status {}", intake.getReferenceNo());
			
		return self();
	}
	    
}
