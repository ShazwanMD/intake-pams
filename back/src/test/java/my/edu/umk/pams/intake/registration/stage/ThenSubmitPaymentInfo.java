package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.policy.model.InIntake;

public class ThenSubmitPaymentInfo extends Stage<ThenSubmitPaymentInfo> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(ThenSubmitPaymentInfo.class);

@Autowired
private AdmissionService admissionService;
	    
@ExpectedScenarioState
private InIntake intake; 
	  
	 public ThenSubmitPaymentInfo I_can_submit_the_payment_info_to_bursary(String matricNo) {
		 return self();
	 }

}
