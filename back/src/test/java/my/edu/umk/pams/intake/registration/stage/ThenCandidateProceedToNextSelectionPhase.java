package my.edu.umk.pams.intake.registration.stage;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.model.InCandidateStatus;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.policy.model.InIntake;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author PAMS
 */
@Pending
@JGivenStage
public class ThenCandidateProceedToNextSelectionPhase extends Stage<ThenCandidateProceedToNextSelectionPhase> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenCandidateProceedToNextSelectionPhase.class);

    @ExpectedScenarioState
    List<InIntakeApplication> applications;

    @Autowired
    private AdmissionService admissionService;
    
    @ExpectedScenarioState
    private InIntake intake; 
    
 //   @ExpectedScenarioState
 //   private InCandidate candidate; 

    public ThenCandidateProceedToNextSelectionPhase candidate_can_proceed_next_selection() {
    	Assert.notNull(intake, "intake is null");
    	
		InCandidate candidate = admissionService.findCandidateByIdentityNo("248674");
    	Assert.notNull(candidate, "list is null");
		LOG.debug("candidate : {}", candidate);
    	
    	List<InCandidate> candidates = admissionService.findCandidates(intake);
    	LOG.debug("candidates is : {}", candidates);
    	Assert.notEmpty(candidates, "list is empty");
    	//LOG.debug("candidate {}",candidates);  //test candidate wujud atau tidak
    	LOG.debug("candidate test {}",candidates);
    	
    	for (InCandidate candidate1 : candidates) {
    		//LOG.debug("candidate {}",candidate1.getStatus());
    		//LOG.debug("candidate test {}",candidate1);
    		Assert.isTrue(InCandidateStatus.SELECTED.equals(candidate1.getStatus()),"Candidate should be selected");
    		LOG.debug("candidate test {}",candidate1.getStatus());
		}
        

        return self();
    }

}