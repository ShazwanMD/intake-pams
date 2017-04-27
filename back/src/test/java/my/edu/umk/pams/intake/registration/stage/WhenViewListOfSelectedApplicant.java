package my.edu.umk.pams.intake.registration.stage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.admission.service.AdmissionService;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import my.edu.umk.pams.intake.policy.service.PolicyService;

@JGivenStage
public class WhenViewListOfSelectedApplicant extends Stage<WhenViewListOfSelectedApplicant> {
	
	private static final Logger LOG = LoggerFactory.getLogger(WhenViewListOfSelectedApplicant.class);
	
	@ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private List<InCandidate> candidates;

    @ExpectedScenarioState
    private InIntake intake;
    
    @ExpectedScenarioState
    private InIntakeApplication intakeApplication;
    
    @Autowired
    private AdmissionService admissionService;
    
    public WhenViewListOfSelectedApplicant View_List_Of_Selected_Applicant() {


		 List<InCandidate> candidates = admissionService.findCandidates(intake);
		 
			for (InCandidate candidate : candidates) {
				
				
			     LOG.debug("this applicant is selected : {}", candidate.getName());
				
			}
	    return self(); 
	}
    
    public WhenViewListOfSelectedApplicant broadcast_result_of_Selected_Applicant() {
	
				admissionService.broadcastResult(intake);

	    return self(); 
    }

}

	
