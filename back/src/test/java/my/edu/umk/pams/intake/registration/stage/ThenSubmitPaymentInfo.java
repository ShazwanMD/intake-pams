package my.edu.umk.pams.intake.registration.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.policy.model.InIntake;

public class ThenSubmitPaymentInfo extends Stage<ThenSubmitPaymentInfo> {
	
	 private static final Logger LOG = LoggerFactory.getLogger(ThenSubmitPaymentInfo.class);

@ExpectedScenarioState
private InIntake intake; 

@ExpectedScenarioState
private InCandidate candidate;

@ProvidedScenarioState
private InCandidateStatus status;
	  
	 public ThenSubmitPaymentInfo I_can_submit_the_payment_info_to_bursary(String matricNo) {
		
	
		/* admissionService.updateSelectedCandidate(candidate);
		 * 
	     Assert.notNull(InCandidateStatus.APPROVED, "candidate status is approved");
	     LOG.debug("candidate application: {}",candidate.getStatus());*/
		 
		 return self();
	 }

}
