package my.edu.umk.pams.intake.registration.stage;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;

import my.edu.umk.pams.bdd.stage.GivenIAmMGSEBAdministrator;
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
//@Pending
@JGivenStage
public class ThenCandidateProceedToNextSelectionPhase extends Stage<ThenCandidateProceedToNextSelectionPhase> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ThenCandidateProceedToNextSelectionPhase.class);

    @ExpectedScenarioState
    List<InIntakeApplication>  application;

    @Autowired
    private AdmissionService admissionService;
    
    @ExpectedScenarioState
    private InIntake intake; 

    public ThenCandidateProceedToNextSelectionPhase candidate_can_proceed_next_selection() {
    	 
    	List<InCandidate> candidates = admissionService.findCandidates(intake);
   
    	//LOG.debug("candidate {}",candidates);  //test candidate wujud atau tidak
    	
    	for (InCandidate candidate : candidates) {
    		//LOG.debug("candidate {}",candidate.getStatus());
    		Assert.isTrue(InCandidateStatus.SELECTED.equals(candidate.getStatus()),"Candidate should be selected");
    		LOG.debug("candidate {}",candidate.getStatus());
		}
        

        return self();
    }

}