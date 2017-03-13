package my.edu.umk.pams.intake.application.stage;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import my.edu.umk.pams.intake.application.model.InBidStatus;
import my.edu.umk.pams.intake.application.model.InIntakeApplication;
import my.edu.umk.pams.intake.application.service.ApplicationService;
import my.edu.umk.pams.intake.identity.model.InApplicant;
import my.edu.umk.pams.intake.identity.model.InUser;
import my.edu.umk.pams.intake.policy.model.InIntake;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author PAMS
 */
@JGivenStage
public class ThenIKnowWhoWillSuperviseMyProject extends Stage<ThenIKnowWhoWillSuperviseMyProject> {
	
	 @Autowired
	    private ApplicationService applicationService;

	    public ThenIKnowWhoWillSuperviseMyProject I_know_who_will_supervise_my_project() {
	      
	        return self();
	    }
}

