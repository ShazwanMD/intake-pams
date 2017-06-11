package my.edu.umk.pams.intake.admission.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@JGivenStage
public class WhenIWantToPreSelectEligibleEndCapableApplicant extends Stage<WhenIWantToPreSelectEligibleEndCapableApplicant> {

	private static final Logger LOG = LoggerFactory.getLogger(WhenIWantToPreSelectEligibleEndCapableApplicant.class);
	
	 	@ProvidedScenarioState
	    private InCandidate candidate;
	    
	    @ExpectedScenarioState
	    InIntakeSession intakeSession;
	    
	    @ExpectedScenarioState
	    private InIntake intake;
	    
	    @Autowired
	    private ApplicationService applicationService;
	    
	    @ProvidedScenarioState
	    private InIntakeApplication preselectApplication;
 
   public WhenIWantToPreSelectEligibleEndCapableApplicant I_want_to_pre_select_eligible_and_capable_applicants() {
		
    	List<InIntakeApplication> applications  =  applicationService.findIntakeApplications(intake,InBidStatus.SELECTED);
		
		 for (InIntakeApplication application : applications) {
         	
         	//Fromm the list, we selected one application and set the data to selectedApplication
			 preselectApplication = application;
         }
	
       return self();
    }
}
