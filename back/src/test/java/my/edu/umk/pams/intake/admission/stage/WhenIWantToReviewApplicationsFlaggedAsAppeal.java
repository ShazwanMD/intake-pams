package my.edu.umk.pams.intake.admission.stage;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

@JGivenStage
public class WhenIWantToReviewApplicationsFlaggedAsAppeal extends Stage <WhenIWantToReviewApplicationsFlaggedAsAppeal> {

	@ExpectedScenarioState
    InIntakeSession intakeSession;

    @ProvidedScenarioState
    private InCandidate candidate;
    
    @ExpectedScenarioState
    private InIntake intake;
    
    @Autowired
    private ApplicationService applicationService;

	public WhenIWantToReviewApplicationsFlaggedAsAppeal I_want_to_review_applications_flagged_as_appeal() {
		
		List<InIntakeApplication> applications  =  applicationService.findIntakeApplications(intake,InBidStatus.APPEAL);
		for (InIntakeApplication inIntakeApplication : applications) {
			inIntakeApplication.getName();
			inIntakeApplication.getAddresses();
			inIntakeApplication.getEmail();
		}
		// TODO Auto-generated method stub
		return null;
			
	}

}
