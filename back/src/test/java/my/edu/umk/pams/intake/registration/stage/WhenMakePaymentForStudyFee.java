package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.policy.model.InIntake;

public class WhenMakePaymentForStudyFee extends Stage<WhenMakePaymentForStudyFee> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(WhenMakePaymentForStudyFee.class);
	
@Autowired
private AdmissionService admissionService;

@ProvidedScenarioState
private InCandidate candidate;

@ExpectedScenarioState
private InIntake intake; 


	  
	 public WhenMakePaymentForStudyFee I_want_to_make_payment_for_my_study_fee_$(String identityNo,String intakeSession) {
		 
		 
		
		 return self();
	 }

}
