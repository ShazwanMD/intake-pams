package my.edu.umk.pams.intake.registration.stage;

import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.registration.service.RegistrationService;

@JGivenStage
public class WhenIWantToScanTheApplicantOfferLetterBarcode extends Stage <WhenIWantToScanTheApplicantOfferLetterBarcode> {

	@Autowired
	private RegistrationService registrationservice;
 
	@ProvidedScenarioState
	private InUser user;

	@Pending
	public WhenIWantToScanTheApplicantOfferLetterBarcode I_want_to_scan_the_applicant_offer_letter_barcode() {
			
		return self();
	}
	    
}
