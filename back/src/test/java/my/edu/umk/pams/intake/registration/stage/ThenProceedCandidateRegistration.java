package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.policy.model.InIntake;


@JGivenStage
public class ThenProceedCandidateRegistration extends Stage<ThenProceedCandidateRegistration>{
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenProceedCandidateRegistration.class);

	  @Autowired
	  private AdmissionService admissionService;
	    
	  @ExpectedScenarioState
	  private InIntake intake; 
	    
	public ThenProceedCandidateRegistration I_can_proceed_with_the_registration(String identityNo) {
		
		Assert.notNull(intake, "intake cannot be null");
		List<InCandidate> candidates = admissionService.findCandidates(intake);
    	Assert.notEmpty(candidates, "candidates cannot be empty");

    	for (InCandidate candidate : candidates) {
    		if (identityNo.equals(candidate.getIdentityNo()))
    		Assert.isTrue(InCandidateStatus.SELECTED.equals(candidate.getStatus()),"Candidate should be selected");
		}
		
		return self();
	}
}
