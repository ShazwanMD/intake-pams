package my.edu.umk.pams.intake.registration.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Pending;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.admission.model.InCandidate;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.policy.model.InIntake;
import my.edu.umk.pams.intake.policy.model.InIntakeSession;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */

@JGivenStage
public class WhenISelectTopApplicants extends Stage<WhenISelectTopApplicants> {

	private static final Logger LOG = LoggerFactory.getLogger (WhenISelectTopApplicants.class);
	
	@ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState
    private InIntake intake;
    
    @ExpectedScenarioState
    private InIntakeApplication application;
    
    @Autowired
    private ApplicationService applicationService;

    public WhenISelectTopApplicants I_select_top_applicants() {
    	
    	List<InIntakeApplication> applications  =  applicationService.findIntakeApplicationsOrderedByMerit(intake);
		for (InIntakeApplication intakeApplication : applications) {
			intakeApplication.getName();
			LOG.debug(intakeApplication.getName());
			intakeApplication.getEmail();
			LOG.debug(intakeApplication.getEmail());
			
			LOG.debug("intake status {} :", intakeApplication.getBidStatus());
			
		}
		
        return self();

    }
}



