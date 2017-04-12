package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.policy.model.InIntake;

public class ThenProceedWithTheRegistration extends Stage<ThenProceedWithTheRegistration>{
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenProceedWithTheRegistration.class);

	  @Autowired
	  private AdmissionService admissionService;
	    
	  @ExpectedScenarioState
	  private InIntake intake; 
	    
	public ThenProceedWithTheRegistration I_can_proceed_with_the_registration(String identityNo) {
		
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
